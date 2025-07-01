package com.employee.service;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    EmployeeRequest createEmployee(EmployeeRequest employee);

    public List<EmployeeRequest> getAllEmployees();

    EmployeeRequest getEmployeeByEid(Long eId) throws EmployeeNotFoundException;

    EmployeeRequest updateEmployeeByEid(EmployeeRequest employee, Long eId);

    EmployeeRequest partialLyUpdateEmployeeByEid(EmployeeRequest employee, Long eId);

    public void deleteEmployeeByEid(Long eId);

    List<EmployeeRequest> getAllEmployeesByCity(String city);

    public EmployeeRequest getEmployeeByNameAndCity(String name, String city);
}
