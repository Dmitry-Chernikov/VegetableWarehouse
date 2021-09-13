package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeWarehouseDto extends AbstractDto{

    private String nameWarehouse;
}
