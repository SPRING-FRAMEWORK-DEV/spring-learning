package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView helloWorld(@RequestParam("city") String city) {
        String textMessage = "Spring, Hello, World! "+city;
        return new ModelAndView("hello", "message", textMessage);
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ModelAndView health() {
        String textMessage = "Spring, Hello, World! ";
        return new ModelAndView("hello", "message", textMessage);
    }
}
