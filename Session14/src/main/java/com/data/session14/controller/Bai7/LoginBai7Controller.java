package com.data.session14.controller.Bai7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@Controller
public class LoginBai7Controller {

    @GetMapping("/loginBai7")
    public String showLoginForm(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    password = cookie.getValue();
                }
            }
        }

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        return "Bai7/login";
    }

    @PostMapping("/loginBai7")
    public String handleLogin(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam(value = "remember", required = false) String remember
    ) {
        if ("admin".equals(username) && "123".equals(password)) {
            request.getSession().setAttribute("username", username);

            if (remember != null) {
                Cookie userCookie = new Cookie("username", username);
                Cookie passCookie = new Cookie("password", password);
                userCookie.setMaxAge(7 * 24 * 60 * 60);
                passCookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            } else {
                Cookie userCookie = new Cookie("username", null);
                Cookie passCookie = new Cookie("password", null);
                userCookie.setMaxAge(0);
                passCookie.setMaxAge(0);
                response.addCookie(userCookie);
                response.addCookie(passCookie);
            }

            return "redirect:/welcome";
        } else {
            request.setAttribute("error", "Sai username hoặc password");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            return "Bai7/login";
        }
    }

    @GetMapping("/welcomeLogin")
    public String welcomePage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            return "redirect:/login";
        }
        return "Bai7/welcome";
    }
}

