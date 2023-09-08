package com.ftn.JhipsterThymeleaf.controller;

import com.ftn.JhipsterThymeleaf.domain.Cenovnik;
import com.ftn.JhipsterThymeleaf.domain.JedinicaMere;
import com.ftn.JhipsterThymeleaf.service.JedinicaMereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static com.ftn.JhipsterThymeleaf.util.SessionUtil.autorizacija;

@Controller
@RequestMapping(value = "/JedinicaMere")
public class JedinicaMereController {
    @Autowired
    JedinicaMereService service;
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
        List<JedinicaMere> list = service.findAll();
        ModelAndView response = new ModelAndView("jedinicaMereGet");
        response.addObject("list", list);
        return response;
    }

    @PostMapping(value = "/Delete")
    public ModelAndView delete(@RequestParam("id") Long id, HttpSession ses, HttpServletResponse res) throws IOException {
        service.delete(id);
        return get(ses, res);
    }
}
