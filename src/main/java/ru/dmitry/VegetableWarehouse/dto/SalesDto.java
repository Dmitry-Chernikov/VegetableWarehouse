package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDto extends AbstractDto{

    private String barcode;
    private String nameTypeVegetable;
    private double countProduct;
    private String clientName;
    private String nameClient;
    private String fullName;
    private Date operationDate;
    private double valuePrice;
}
