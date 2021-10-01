package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Продукты\"")
public class ProductsDto extends AbstractDto{
    @ApiModelProperty(value = "Наименование продукта")
    private String nameTypeVegetable;
}
