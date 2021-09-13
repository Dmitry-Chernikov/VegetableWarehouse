package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto extends AbstractDto{

    private String nameTypeVegetable;
}
