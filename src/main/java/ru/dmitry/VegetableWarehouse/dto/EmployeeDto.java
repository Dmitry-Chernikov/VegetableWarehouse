package ru.dmitry.VegetableWarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto extends AbstractDto{
    private Long id;
    private String fullName;
    private Date dateBirth;
    private String position;
    private String accommodationAddress;
    private String telephoneHome;
    private String telephoneMobil;
}
