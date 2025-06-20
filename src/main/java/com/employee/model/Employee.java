package com.employee.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Component
@Setter
@Getter
public class Employee {
    //resource UNIQUE id
    private String eId;
    private String ename;
    private String city;
    private String pin;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}
