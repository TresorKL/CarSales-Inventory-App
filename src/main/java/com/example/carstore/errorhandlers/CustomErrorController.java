package com.example.carstore.errorhandlers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH+"404", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView error404(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("status", HttpStatus.NOT_FOUND.value());
        return modelAndView;
    }
    @RequestMapping(value = PATH, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView error500(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return modelAndView;
    }
    @RequestMapping(value = PATH+"400", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView error400(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("status", HttpStatus.BAD_REQUEST.value());
        return modelAndView;
    }

    @RequestMapping(value = PATH+"401", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView error401(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("status", HttpStatus.UNAUTHORIZED.value());
        return modelAndView;
    }






}
