package com.employee.service.impl;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.EmployeeRequest;
import com.employee.repo.entity.EmployeeEntity;
import com.employee.repo.impl.EmployeeRepositoryImpl;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public EmployeeRequest getEmployeeByEid(Long eId) throws EmployeeNotFoundException {

        Optional<EmployeeEntity> employeeEntity = employeeRepositoryImpl.getEmployeeByEid(eId);
        if(employeeEntity.isPresent()) {
            return convertEmployeeEntityToEmployeeRequest(employeeEntity.get());
        }
        throw new EmployeeNotFoundException("Employee not found", HttpStatus.NOT_FOUND.value());
    }

    @Override
    public EmployeeRequest updateEmployeeByEid(EmployeeRequest employee, Long eId) {
        return employeeRepositoryImpl.updateEmployeeByEid(employee, eId);
    }

    @Override
    public EmployeeRequest partialLyUpdateEmployeeByEid(EmployeeRequest employee, Long eId) {
        return employeeRepositoryImpl.partialLyUpdateEmployeeByEid(employee, eId);
    }

    @Override
    public void deleteEmployeeByEid(Long eId) {
        employeeRepositoryImpl.deleteEmployeeByEid(eId);
    }

    @Override
    public List<EmployeeRequest> getAllEmployeesByCity(String city) {
        return employeeRepositoryImpl.getAllEmployeesByCity(city);
    }

    @Override
    public EmployeeRequest getEmployeeByNameAndCity(String name, String city) {
        return employeeRepositoryImpl.getEmployeeByNameAndCity(name, city);
    }

    private EmployeeRequest  convertEmployeeEntityToEmployeeRequest(EmployeeEntity employeeEntity) {
        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setId(employeeEntity.getId());
        employeeRequest.setName(employeeEntity.getName());
        employeeRequest.setCity(employeeEntity.getCity());
        employeeRequest.setPin(employeeEntity.getPin());
        return employeeRequest;
    }

}
