package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@Data
public class BaseProductsDto extends AbstractDto{

    private String barcode;
    private String nameWarehouse;
    private String varietyName;
//    private Date shelfLife;
//    private String designationUnit;
//    private String manufactureName;
//    private String manufactureCountry;
}
