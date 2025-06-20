package com.employee.repo;

import com.employee.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Repository
public class EmployeeRepo {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        /*Employee employee1 = new Employee();
        employee1.setEname("Ram");
        employee1.seteId("E100");

        Employee employee2 = new Employee();
        employee2.setEname("Lakshman");
        employee2.seteId("E102");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);*/

        return employeeList;
    }

    public Employee createEmployee(Employee employee) {
        // collection --> db
        employee.seteId(UUID.randomUUID().toString());
        employeeList.add(employee);
        return employee;
    }

    public Employee getEmployeeByEid(String eId) {
        Optional<Employee> employee = employeeList.stream()
                .filter(e-> e.geteId().equalsIgnoreCase(eId))
                .findFirst();
        return employee.get();
    }

    public void deleteEmployeeByEid(String eId) {
        employeeList.remove(getEmployeeByEid(eId));
    }

    public Employee updateEmployeeByEid(Employee employee, String eId) {
        for(Employee e : employeeList) {
            if(e.geteId().equals(eId)) {
                e.setCity(employee.getCity());
                e.setPin(employee.getPin());
            }
        }
        return getEmployeeByEid(eId);
    }

    public Employee partialLyUpdateEmployeeByEid(Employee employee, String eId) {

        for(Employee e : employeeList) {
            if(e.geteId().equals(eId)) {
                e.setPin(employee.getPin());
            }
        }
        return getEmployeeByEid(eId);
    }
}
