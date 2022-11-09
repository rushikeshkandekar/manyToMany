package com.example.manytomany.controller;

import com.example.manytomany.model.Department;
import com.example.manytomany.model.DepartmentResponse;
import com.example.manytomany.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody Department department) {
        DepartmentResponse departmentResponse = departmentService.createDepartment(department);
        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/departments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getByDepartmentId(@PathVariable Long id) {
        Department department = departmentService.getByDepartmentId(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping(value = "/departments/{id}")
    public ResponseEntity<Void> deleteByDepartmentId(@PathVariable Long id) {
        departmentService.deleteByDepartmentId(id);
        return ResponseEntity.ok().build();
    }
}
