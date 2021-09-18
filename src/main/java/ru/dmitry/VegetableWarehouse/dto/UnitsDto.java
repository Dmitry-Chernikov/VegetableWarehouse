package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

@Getter
@Setter
public class UnitsDto extends AbstractDto {

    private String measurementUnit;
    private String designationUnit;
}
