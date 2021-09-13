package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseProductsDto extends AbstractDto{

    private String barcode;
    private String nameWarehouse;
    private String varietyName;
}
