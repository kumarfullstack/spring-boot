package com.employee.repo.impl;

import com.employee.model.EmployeeRequest;
import com.employee.repo.EmployeeRepository;
import com.employee.repo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
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

    public Optional<EmployeeEntity> getEmployeeByEid(Long eId) {
        return employeeRepository.findById(eId);
    }

    public EmployeeRequest updateEmployeeByEid(EmployeeRequest employeeRequest, Long eId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(eId);

        employeeEntity.get().setPin(employeeRequest.getPin());
        employeeEntity.get().setCity(employeeRequest.getCity());

        EmployeeEntity entity = employeeRepository.save(employeeEntity.get());
        return convertEmployeeEntityToEmployeeRequest(entity);
    }

    public EmployeeRequest partialLyUpdateEmployeeByEid(EmployeeRequest employeeRequest, Long eId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(eId);
        employeeEntity.get().setPin(employeeRequest.getPin());

        EmployeeEntity entity = employeeRepository.save(employeeEntity.get());
        return convertEmployeeEntityToEmployeeRequest(entity);
    }

    private EmployeeRequest  convertEmployeeEntityToEmployeeRequest(EmployeeEntity employeeEntity) {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setId(employeeEntity.getId());
        employeeRequest.setName(employeeEntity.getName());
        employeeRequest.setCity(employeeEntity.getCity());
        employeeRequest.setPin(employeeEntity.getPin());
        return employeeRequest;
    }

    public void deleteEmployeeByEid(Long eId) {
        employeeRepository.deleteById(eId);
    }

    public List<EmployeeRequest> getAllEmployeesByCity(String city) {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAllEmployeeByCity(city);
        List<EmployeeRequest> employeeRequestList = new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeEntityList) {
            employeeRequestList.add(convertEmployeeEntityToEmployeeRequest(employeeEntity));
        }
        return employeeRequestList;
    }

    public EmployeeRequest getEmployeeByNameAndCity(String name, String city) {
        EmployeeEntity employeeEntity = employeeRepository.findByNameAndCity(name, city);
        return convertEmployeeEntityToEmployeeRequest(employeeEntity);
    }
}


