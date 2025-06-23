package com.employee.service;

import com.employee.model.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    EmployeeRequest createEmployee(EmployeeRequest employee);

    public List<EmployeeRequest> getAllEmployees();
/*
    public List<EmployeeRequest> getAllEmployees();

    EmployeeRequest getEmployeeByEid(String eId);

    void deleteEmployeeByEid(String eId);

    EmployeeRequest updateEmployeeByEid(EmployeeRequest employee, String eId);

    EmployeeRequest partialLyUpdateEmployeeByEid(EmployeeRequest employee, String eId);*/
}
