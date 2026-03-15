package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ApiModel("Атрибуты сущности таблицы \"Единица измерения\"")
public class UnitsDto extends AbstractDto {
    @ApiModelProperty(value = "Измеряемая величина")
    private String measurementUnit;
    @ApiModelProperty(value = "Обозначение единицы измерения")
    private String designationUnit;
}
