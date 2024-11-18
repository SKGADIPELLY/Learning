package org.saic.interview.controllers;

import org.saic.interview.modal.DepartmentModal;
import org.saic.interview.modal.EmployeeModal;
import org.saic.interview.services.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired private DepartmentServiceImpl departmentService;

    @GetMapping(value = "/showDepartments")
    public ResponseEntity<List<DepartmentModal>> findAllDepartments() {
        List<DepartmentModal> modals = departmentService.findAll();
        return ResponseEntity.ok(modals);
    }

    @GetMapping("findDeparment/{id}")
    public DepartmentModal findDepartmentById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @GetMapping("/findByName/{id}")
    public DepartmentModal findDepartmentByName(@PathVariable String name) {
        return departmentService.findByName(name);
    }
    @PostMapping("/saveDepartment")
    public ResponseEntity<HttpStatus> createEmployee(@RequestBody DepartmentModal modal) {
        departmentService.save(modal);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }



}
