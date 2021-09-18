package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class GoodsDto extends AbstractDto{

    private String nameTypeVegetable;
    private String varietyName;
    private Date shelfLife;
    private String designationUnit;
    private String manufactureName;
    private String manufactureCountry;
}
