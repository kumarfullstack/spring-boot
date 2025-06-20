package com.employee.service.impl;

import com.employee.model.Employee;
import com.employee.repo.EmployeeRepo;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.createEmployee(employee);
    }

    @Override
    public Employee getEmployeeByEid(String eId) {
        return employeeRepo.getEmployeeByEid(eId);
    }

    @Override
    public void deleteEmployeeByEid(String eId) {
        employeeRepo.deleteEmployeeByEid(eId);
    }

    @Override
    public Employee updateEmployeeByEid(Employee employee, String eId) {
        return employeeRepo.updateEmployeeByEid(employee, eId);
    }

    @Override
    public Employee partialLyUpdateEmployeeByEid(Employee employee, String eId) {
        return employeeRepo.partialLyUpdateEmployeeByEid(employee, eId);
    }
}
