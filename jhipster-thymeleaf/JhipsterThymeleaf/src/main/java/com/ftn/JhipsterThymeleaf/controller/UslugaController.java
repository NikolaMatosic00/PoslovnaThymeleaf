package com.ftn.JhipsterThymeleaf.controller;

import com.ftn.JhipsterThymeleaf.domain.Cenovnik;
import com.ftn.JhipsterThymeleaf.domain.Grupa;
import com.ftn.JhipsterThymeleaf.domain.JedinicaMere;
import com.ftn.JhipsterThymeleaf.domain.Usluga;
import com.ftn.JhipsterThymeleaf.service.CenovnikService;
import com.ftn.JhipsterThymeleaf.service.GrupaService;
import com.ftn.JhipsterThymeleaf.service.JedinicaMereService;
import com.ftn.JhipsterThymeleaf.service.UslugaService;
import com.ftn.JhipsterThymeleaf.service.dto.PromenaCenovnikaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static com.ftn.JhipsterThymeleaf.util.SessionUtil.autorizacija;

@Controller
@RequestMapping(value = "/Usluga")
public class UslugaController {
    @Autowired
    UslugaService service;

    @Autowired
    GrupaService grupaService;

    @Autowired
    JedinicaMereService jedinicaMereService;

    @Autowired
    CenovnikService cenovnikService;
    @Autowired
    private ServletContext servletContext;
    private String baseURL;

    @PostConstruct
    public void init() {
        baseURL = servletContext.getContextPath() + "/";
    }

    @GetMapping(value = "/Get")
    public ModelAndView get(HttpSession ses, HttpServletResponse res) throws IOException {
        autorizacija(ses, baseURL, res);
        List<Usluga> list = service.findAll();
        ModelAndView response = new ModelAndView("uslugaGet");
        response.addObject("list", list);
        return response;
    }

    @GetMapping(value = "/Create")
    public ModelAndView create() throws IOException {
        List<Cenovnik> cenovnikList = cenovnikService.findAll();
        List<JedinicaMere> jedinicaMereList = jedinicaMereService.findAll();
        List<Grupa> grupaList = grupaService.findAll();

        ModelAndView response = new ModelAndView("uslugaCreate");
        response.addObject("req", new Usluga());
        response.addObject("cenovnikList", cenovnikList);
        response.addObject("jedinicaMereList", jedinicaMereList);
        response.addObject("grupaList", grupaList);

        return response;
    }

    @PostMapping(value = "/Create")
    public ModelAndView create(@ModelAttribute Usluga req, HttpSession ses, HttpServletResponse res) throws IOException {
        service.save(req);
        return get(ses, res);
    }

    @PostMapping(value = "/Delete")
    public ModelAndView delete(@RequestParam("id") Long id, HttpSession ses, HttpServletResponse res) throws IOException {
        service.delete(id);
        return get(ses, res);
    }

    @PostMapping(value = "/PromenaCenovnika")
    public ModelAndView promenaCenovnika(@RequestParam("procenat") int procenat, HttpSession ses, HttpServletResponse res) throws IOException {
        PromenaCenovnikaDTO promenaCenovnikaDTO = new PromenaCenovnikaDTO();
        promenaCenovnikaDTO.setProcenat(procenat);
        service.promenaCenovnika(promenaCenovnikaDTO);
        return get(ses, res);
    }
}
