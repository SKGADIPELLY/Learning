package org.saic.interview.controllers;

import org.saic.interview.modal.DepartmentModal;
import org.saic.interview.modal.EmployeeModal;
import org.saic.interview.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired private EmployeeServiceImpl employeeService;

    @GetMapping(value = "/showEmployees")
    public ResponseEntity<List<EmployeeModal>> findAllEmployees() {
        List<EmployeeModal> modals = employeeService.findAll();
        return ResponseEntity.ok(modals);
    }
    @GetMapping("/findEmployee/{id}")
    public EmployeeModal findEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }
    @GetMapping("/findByEmail/{id}")
    public EmployeeModal findEmployeeByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email);
    }
    @PostMapping("/saveEmployee")
    public ResponseEntity<HttpStatus> createEmployee(@RequestBody EmployeeModal modal) {
        employeeService.save(modal);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
