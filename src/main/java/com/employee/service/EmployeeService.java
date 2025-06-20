package com.employee.service;

import com.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Employee getEmployeeByEid(String eId);

    void deleteEmployeeByEid(String eId);

    Employee updateEmployeeByEid(Employee employee, String eId);

    Employee partialLyUpdateEmployeeByEid(Employee employee, String eId);
}
