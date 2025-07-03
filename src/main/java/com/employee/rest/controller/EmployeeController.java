package com.employee.rest.controller;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.EmployeeRequest;
import com.employee.service.EmployeeService;
import com.employee.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create/employee")
    public ResponseEntity<EmployeeRequest> createEmployee(@RequestBody EmployeeRequest employee) {
        EmployeeRequest employeeResponse = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeRequest>> getAllEmployees() {
        List<EmployeeRequest> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employee/{eId}")
    public ResponseEntity<EmployeeRequest> getEmployeeByEid(@PathVariable Long eId) throws EmployeeNotFoundException {
        EmployeeRequest employee = employeeService.getEmployeeByEid(eId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //fully update of resource
    @PutMapping("/employee/{eId}")
    public ResponseEntity<EmployeeRequest> updateEmployeeByEid(@RequestBody EmployeeRequest employee, @PathVariable Long eId) {
        EmployeeRequest employeeResponse = employeeService.updateEmployeeByEid(employee, eId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    //partialLy update of resource
    @PatchMapping("/employee")
    public ResponseEntity<EmployeeRequest> partialLyUpdateEmployeeByEid(@RequestBody EmployeeRequest employee,
                                                                        @RequestParam("empId") Long eId) {
        EmployeeRequest employeeResponse = employeeService.partialLyUpdateEmployeeByEid(employee, eId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{eId}")
    public ResponseEntity<String> deleteEmployeeByEid(@PathVariable Long eId) {
        employeeService.deleteEmployeeByEid(eId);
        return new ResponseEntity<String>("Employee has deleted eid : " + eId, HttpStatus.OK);
    }

    @GetMapping("/employees/{city}")
    public ResponseEntity<List<EmployeeRequest>> getAllEmployeesByCity(@PathVariable String city) {
        List<EmployeeRequest> employeeList = employeeService.getAllEmployeesByCity(city);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employee/{name}/{city}")
    public ResponseEntity<EmployeeRequest> getEmployeeByNameAndCity(@PathVariable String name,
                                                                          @PathVariable String city) {
        EmployeeRequest employeeRequest  = employeeService.getEmployeeByNameAndCity(name, city);
        return new ResponseEntity<>(employeeRequest, HttpStatus.OK);
    }

}
