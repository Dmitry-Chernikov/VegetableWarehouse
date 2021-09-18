package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class SalesDto extends AbstractDto{

    private String barcode;
    private String nameTypeVegetable;
    private double countProduct;
    private String designationUnit;
    private String clientName;
    private String nameClient;
    private String fullName;
    private Date operationDate;
    private double valuePrice;
}
