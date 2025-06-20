package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee employeeResponse = employeeService.createEmployee(employee);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    //fully update of resource
    @PutMapping("/employee/{eId}")
    public ResponseEntity<Employee> updateEmployeeByEid(@RequestBody Employee employee, @PathVariable String eId) {
        Employee employeeResponse = employeeService.updateEmployeeByEid(employee, eId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    //partialLy update of resource
    @PatchMapping("/employee")
    public ResponseEntity<Employee> partialLyUpdateEmployeeByEid(@RequestBody Employee employee, @RequestParam("empId") String eId) {
        Employee employeeResponse = employeeService.partialLyUpdateEmployeeByEid(employee, eId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }


/*    @RequestMapping("/employees")
    @ResponseBody*/
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    @GetMapping("/employees/{eId}")
    public ResponseEntity<Employee> getEmployeeByEid(@PathVariable String eId) {
        Employee employee = employeeService.getEmployeeByEid(eId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{eId}")
    public ResponseEntity<String> deleteEmployeeByEid(@PathVariable String eId) {
        employeeService.deleteEmployeeByEid(eId);
        return new ResponseEntity<String>("Employee has deleted eid : " + eId, HttpStatus.OK);
    }

}
