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
public class SalesDto extends AbstractDto{
    private Long id;
    private String barcode;
    private Long baseProductsId;
    private double countProduct;
    private String clientName;
    private Long clientsId;
    private Long employeeId;;
    private Date operationDate;
    private double valuePrice;
}
