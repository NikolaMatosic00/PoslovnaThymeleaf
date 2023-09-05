package com.ftn.JhipsterThymeleaf.util;

import com.ftn.JhipsterThymeleaf.domain.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionUtil {
    public static final String KORISNIK_KEY = "prijavljeniKorisnik";
    public static void autorizacija(HttpSession session, String baseURL, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute(KORISNIK_KEY);

        if(user == null){
            response.sendRedirect(baseURL + "prijava.html");
        }
    }
}
