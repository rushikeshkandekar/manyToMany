package com.example.manytomany.controller;

import com.example.manytomany.model.Employee;
import com.example.manytomany.model.EmployeeResponse;
import com.example.manytomany.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee) {
        EmployeeResponse employeeResponse = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/employees-department/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/employees/{empId}/departments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEmployee(@PathVariable Long empId, @PathVariable Long id) {
        employeeService.updateEmployee(empId, id);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/employees/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.updateEmployeeById(id,employee);
        return ResponseEntity.ok().build();
    }
}
