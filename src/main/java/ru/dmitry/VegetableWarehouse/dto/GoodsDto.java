package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

import java.util.Date;

@Data
public class GoodsDto extends AbstractDto{

    private String nameTypeVegetable;
    private String varietyName;
    private Date shelfLife;
    private String designationUnit;
    private String manufactureName;
    private String manufactureCountry;
}
