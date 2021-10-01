package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Тип склада\"")
public class TypeWarehouseDto extends AbstractDto{
    @ApiModelProperty(value = "Наименование склада")
    private String nameWarehouse;
}
