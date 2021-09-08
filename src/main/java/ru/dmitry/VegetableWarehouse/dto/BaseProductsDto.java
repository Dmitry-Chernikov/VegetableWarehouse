package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseProductsDto extends AbstractDto{
    private Long id;
    private String barcode = UUID.randomUUID().toString();;
    private Long typeWarehouseId;
    private Long goodsId;
}
