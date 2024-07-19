package org.example.controllers;

import jakarta.validation.Valid;
import org.example.model.EmployeeModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/employees")
@Validated
public class EmployeeController {


    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeModel> getById(@PathVariable("id") int employeeId) {
        EmployeeModel e = new EmployeeModel();
        e.setId(employeeId);
        return ResponseEntity.ok(e);
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public EmployeeModel getOne() {
        EmployeeModel e = new EmployeeModel();
        e.setId(100);
        return e;
    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EmployeeModel>> getAll() {
        List<EmployeeModel> list = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> {
            EmployeeModel e = new EmployeeModel();
            e.setId(i);
            list.add(e);
        });
        return ResponseEntity.of(Optional.of(list));
    }

    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeModel employeeModel, BindingResult result) {

        if (result.hasErrors()) {
            String errors = result.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        employeeModel.setId(employeeModel.getId() * 2);
        return ResponseEntity.ok(employeeModel);
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeModel employeeModel) {
        employeeModel.setId(employeeModel.getId() * 3);
        return ResponseEntity.ok(employeeModel);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EmployeeModel> deleteById(@PathVariable("id") int employeeId) {
        EmployeeModel e = new EmployeeModel();
        e.setId(-1);
        return ResponseEntity.ok(e);
    }

}
