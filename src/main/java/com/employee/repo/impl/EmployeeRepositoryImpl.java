package com.employee.repo.impl;

import com.employee.model.EmployeeRequest;
import com.employee.repo.EmployeeRepository;
import com.employee.repo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeRequest createEmployee(EmployeeRequest employeeRequest) {

        // mapped from request to entity
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeRequest.getName());
        employeeEntity.setCity(employeeRequest.getCity());
        employeeEntity.setPin(employeeRequest.getPin());

        //save employee data in to
        EmployeeEntity response = employeeRepository.save(employeeEntity);
        employeeRequest.setId(response.getId());
        return employeeRequest;
    }

    public List<EmployeeRequest> getAllEmployees() {
        List<EmployeeEntity> employeeEntities =employeeRepository.findAll();
        //convert enetites into list request
        List<EmployeeRequest> employeeRequests = new ArrayList<>();

        for(EmployeeEntity entity : employeeEntities) {
            EmployeeRequest employeeRequest = new EmployeeRequest();
            employeeRequest.setId(entity.getId());
            employeeRequest.setName(entity.getName());
            employeeRequest.setCity(entity.getCity());
            employeeRequest.setPin(entity.getPin());
            employeeRequests.add(employeeRequest);
        }
        return employeeRequests;
    }

/*
    public List<EmployeeRequest> getAllEmployees() {
        return employeeList;
    }



    public EmployeeRequest getEmployeeByEid(String eId) {
        Optional<EmployeeRequest> employee = employeeList.stream()
                .filter(e -> e.geteId().equalsIgnoreCase(eId))
                .findFirst();
        return employee.get();
    }

    public void deleteEmployeeByEid(String eId) {
        employeeList.remove(getEmployeeByEid(eId));
    }

    public EmployeeRequest updateEmployeeByEid(EmployeeRequest employee, String eId) {
        for (EmployeeRequest e : employeeList) {
            if (e.geteId().equals(eId)) {
                e.setCity(employee.getCity());
                e.setPin(employee.getPin());
            }
        }
        return getEmployeeByEid(eId);
    }

    public EmployeeRequest partialLyUpdateEmployeeByEid(EmployeeRequest employee, String eId) {

        for (EmployeeRequest e : employeeList) {
            if (e.geteId().equals(eId)) {
                e.setPin(employee.getPin());
            }
        }
        return getEmployeeByEid(eId);
    }*/
}
