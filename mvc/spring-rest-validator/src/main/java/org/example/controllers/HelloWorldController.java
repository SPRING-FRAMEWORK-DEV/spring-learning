package org.example.controllers;

import org.example.model.EmployeeModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    @ResponseBody
    public String health() {
        String message = "Spring MVC Rest, Hello, World! ";
        return message;
    }

    @GetMapping(value = "/employees/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<EmployeeModel> getById(@PathVariable("id") int employeeId){
        EmployeeModel e = new EmployeeModel();
        e.setId(employeeId);
        return ResponseEntity.ok(e);
    }
}
