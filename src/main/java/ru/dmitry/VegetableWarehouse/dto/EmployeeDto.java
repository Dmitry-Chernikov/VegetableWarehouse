package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

import java.util.Date;

@Data
public class EmployeeDto extends AbstractDto{

    private String fullName;
    private Date dateBirth;
    private String position;
    private String accommodationAddress;
    private String telephoneHome;
    private String telephoneMobil;
}
