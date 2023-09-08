package com.ftn.JhipsterThymeleaf.controller;

import com.ftn.JhipsterThymeleaf.domain.*;
import com.ftn.JhipsterThymeleaf.service.GrupaService;
import com.ftn.JhipsterThymeleaf.service.KategorijaPDVService;
import com.ftn.JhipsterThymeleaf.service.PDVService;
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
@RequestMapping(value = "/Grupa")
public class GrupaController {

    @Autowired
    GrupaService service;

    @Autowired
    KategorijaPDVService kategorijaPDVService;
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
        List<Grupa> list = service.findAll();
        ModelAndView response = new ModelAndView("grupaGet");
        response.addObject("list", list);
        return response;
    }

    @GetMapping(value = "/Create")
    public ModelAndView create() throws IOException {
        List<KategorijaPDV> kategorijaPDVList = kategorijaPDVService.findAll();

        ModelAndView response = new ModelAndView("grupaCreate");
        response.addObject("req", new Grupa());
        response.addObject("kategorijaPDVList", kategorijaPDVList);

        return response;
    }

    @PostMapping(value = "/Create")
    public ModelAndView create(@ModelAttribute Grupa req, HttpServletResponse response) throws IOException {
        service.save(req);
        response.sendRedirect("/JhipsterThymeleaf/Grupa/Get");
        return null;
    }

    @PostMapping(value = "/Delete")
    public ModelAndView delete(@RequestParam("id") Long id, HttpSession ses, HttpServletResponse res) throws IOException {
        service.delete(id);
        return get(ses, res);
    }
}
