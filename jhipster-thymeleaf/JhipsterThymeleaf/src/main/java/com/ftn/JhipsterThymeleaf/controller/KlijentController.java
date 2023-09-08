package com.ftn.JhipsterThymeleaf.controller;

import com.ftn.JhipsterThymeleaf.domain.*;
import com.ftn.JhipsterThymeleaf.service.KlijentService;
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
@RequestMapping(value = "/Klijent")
public class KlijentController {

    @Autowired
    KlijentService service;

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
        List<Klijent> list = service.findAll();
        ModelAndView response = new ModelAndView("klijentGet");
        response.addObject("list", list);
        return response;
    }

    @GetMapping(value = "/Create")
    public ModelAndView create() throws IOException {
        ModelAndView response = new ModelAndView("klijentCreate");

        response.addObject("req", new Klijent());

        return response;
    }

    @PostMapping(value = "/Create")
    public ModelAndView create(@ModelAttribute Klijent req, HttpSession ses, HttpServletResponse res) throws IOException {
        service.save(req);
        return get(ses, res);
    }

    @PostMapping(value = "/Delete")
    public ModelAndView delete(@RequestParam("id") Long id, HttpSession ses, HttpServletResponse res) throws IOException {
        service.delete(id);
        return get(ses, res);
    }
}
