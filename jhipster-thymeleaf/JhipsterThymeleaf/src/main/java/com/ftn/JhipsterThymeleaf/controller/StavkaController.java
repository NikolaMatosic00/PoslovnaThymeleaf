package com.ftn.JhipsterThymeleaf.controller;

import com.ftn.JhipsterThymeleaf.domain.*;
import com.ftn.JhipsterThymeleaf.service.FakturaService;
import com.ftn.JhipsterThymeleaf.service.StavkaService;
import com.ftn.JhipsterThymeleaf.service.UslugaService;
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
@RequestMapping(value = "/Stavka")
public class StavkaController {
    @Autowired
    StavkaService service;

    @Autowired
    FakturaService fakturaService;

    @Autowired
    UslugaService uslugaService;
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
        List<Stavka> list = service.findAll();
        ModelAndView response = new ModelAndView("stavkaGet");
        response.addObject("list", list);
        return response;
    }

    @GetMapping(value = "/Create")
    public ModelAndView create() throws IOException {
        List<Faktura> fakturaList = fakturaService.findAll();
        List<Usluga> uslugaList = uslugaService.findAll();

        ModelAndView response = new ModelAndView("stavkaCreate");
        response.addObject("req", new Stavka());
        response.addObject("fakturaList", fakturaList);
        response.addObject("uslugaList", uslugaList);

        return response;
    }

    @PostMapping(value = "/Create")
    public ModelAndView create(@ModelAttribute Stavka req, HttpServletResponse response) throws Exception {
        service.save(req);
        response.sendRedirect("/JhipsterThymeleaf/Stavka/Get");
        return null;
    }

    @PostMapping(value = "/Delete")
    public ModelAndView delete(@RequestParam("id") Long id, HttpSession ses, HttpServletResponse res) throws IOException {
        service.delete(id);
        return get(ses, res);
    }
}
