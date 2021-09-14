package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

import java.util.Date;

@Data
public class PurchaseDto extends AbstractDto{

    private String barcode;
    private String nameTypeVegetable;
    private double countProduct;
    private String designationUnit;
    private String suppliersName;
    private String name;
    private String fullName;
    private Date operationDate;
    private double valuePrice;
}
