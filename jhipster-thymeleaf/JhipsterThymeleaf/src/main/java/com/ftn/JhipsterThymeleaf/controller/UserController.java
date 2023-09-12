package com.ftn.JhipsterThymeleaf.controller;

import com.ftn.JhipsterThymeleaf.domain.User;
import com.ftn.JhipsterThymeleaf.service.UserService;
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

import static com.ftn.JhipsterThymeleaf.util.SessionUtil.KORISNIK_KEY;

@Controller
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private ServletContext servletContext;
    private String baseURL;

    @PostConstruct
    public void init() {
        baseURL = servletContext.getContextPath() + "/";
    }

    @PostMapping(value = "/Login")
    public ModelAndView postLogin(@RequestParam String korisnickoIme, @RequestParam String lozinka,
                                  HttpSession session, HttpServletResponse response) throws IOException {
        User user = userService.login(korisnickoIme, lozinka);
        if(user == null){
            response.sendRedirect(baseURL + "prijava.html");
            return null;
        }
        session.setAttribute(KORISNIK_KEY, user);
        response.sendRedirect(baseURL + "user.html");
        return null;
    }

    @GetMapping(value = "/Logout")
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate();

        response.sendRedirect(baseURL);
    }
}
