package com.employee.service.impl;

import com.employee.model.EmployeeRequest;
import com.employee.repo.impl.EmployeeRepositoryImpl;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositoryImpl employeeRepositoryImpl;

    @Override
    public EmployeeRequest createEmployee(EmployeeRequest employeeRequest) {
        return employeeRepositoryImpl.createEmployee(employeeRequest);
    }


    @Override
    public List<EmployeeRequest> getAllEmployees() {
        return employeeRepositoryImpl.getAllEmployees();
    }

/*
    @Override
    public EmployeeRequest getEmployeeByEid(String eId) {
        return employeeRepo.getEmployeeByEid(eId);
    }

    @Override
    public void deleteEmployeeByEid(String eId) {
        employeeRepo.deleteEmployeeByEid(eId);
    }

    @Override
    public EmployeeRequest updateEmployeeByEid(EmployeeRequest employee, String eId) {
        return employeeRepo.updateEmployeeByEid(employee, eId);
    }

    @Override
    public EmployeeRequest partialLyUpdateEmployeeByEid(EmployeeRequest employee, String eId) {
        return employeeRepo.partialLyUpdateEmployeeByEid(employee, eId);
    }
*/
}
