package com.ftn.JhipsterThymeleaf.controller;

import com.ftn.JhipsterThymeleaf.domain.*;
import com.ftn.JhipsterThymeleaf.repository.FakturaRepository;
import com.ftn.JhipsterThymeleaf.service.FakturaService;
import com.ftn.JhipsterThymeleaf.service.KlijentService;
import com.ftn.JhipsterThymeleaf.service.TekucaGodinaService;
import com.ftn.JhipsterThymeleaf.service.dto.DownloadKIFDTO;
import com.ftn.JhipsterThymeleaf.util.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static com.ftn.JhipsterThymeleaf.util.SessionUtil.autorizacija;

@Controller
@RequestMapping(value = "/Faktura")
public class FakturaController {

    @Autowired
    FakturaService service;

    @Autowired
    KlijentService klijentService;

    @Autowired
    TekucaGodinaService tekucaGodinaService;
    @Autowired
    private ServletContext servletContext;
    private String baseURL;
    @Autowired
    private FakturaRepository fakturaRepository;

    @PostConstruct
    public void init() {
        baseURL = servletContext.getContextPath() + "/";
    }

    @GetMapping(value = "/Get")
    public ModelAndView get(HttpSession ses, HttpServletResponse res) throws IOException {
        autorizacija(ses, baseURL, res);
        List<Faktura> list = service.findAll();
        ModelAndView response = new ModelAndView("fakturaGet");
        response.addObject("list", list);
        return response;
    }

    @GetMapping(value = "/Create")
    public ModelAndView create() throws IOException {
        List<Klijent> klijentList = klijentService.findAll();
        List<TekucaGodina> tekucaGodinaList = tekucaGodinaService.findAll();

        ModelAndView response = new ModelAndView("fakturaCreate");
        response.addObject("req", new Faktura());
        response.addObject("klijentList", klijentList);
        response.addObject("tekucaGodinaList", tekucaGodinaList);

        return response;
    }

    @PostMapping(value = "/Create")
    public ModelAndView create(@ModelAttribute Faktura req, HttpServletResponse response) throws IOException {
        req.setDatum(Instant.now());
        service.save(req);
        response.sendRedirect("/JhipsterThymeleaf/Stavka/Get");
        return null;
    }

    @PostMapping(value = "/Delete")
    public ModelAndView delete(@RequestParam("id") Long id, HttpSession ses, HttpServletResponse res) throws IOException {
        service.delete(id);
        return get(ses, res);
    }

    @RequestMapping(value = "/Report", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> report(@RequestParam("id") Long id) throws Exception {
        Optional<Faktura> fakturaOpt = service.findOne(id);
        if (!fakturaOpt.isPresent()) {
            throw new Exception("Invalid ID");
        }
        Faktura faktura = fakturaOpt.get();
        ByteArrayInputStream bis = GeneratePdfReport.downloadFaktura(faktura);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/KIF", method = RequestMethod.POST, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> kif(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) throws Exception {
        DownloadKIFDTO request = new DownloadKIFDTO();
        request.setDateFrom(dateFrom);
        request.setDateTo(dateTo);

        List<Faktura> fakturaList = fakturaRepository.findAllByDatumIsBetween(
                request.getDateFrom().toInstant(),
                request.getDateTo().toInstant()
        );

        if (fakturaList.isEmpty()) {
            throw new Exception("Invalid range, nothing found");
        }
        ByteArrayInputStream bis = GeneratePdfReport.downloadKIF(fakturaList);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
    }
}
