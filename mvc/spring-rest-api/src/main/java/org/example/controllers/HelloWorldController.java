package org.example.controllers;

import org.example.model.EmployeeModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    @ResponseBody
    public String health() {
        String message = "Spring MVC Rest, Hello, World! ";
        return message;
    }
}
