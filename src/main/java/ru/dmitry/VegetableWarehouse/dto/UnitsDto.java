package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Еденица измерения\"")
public class UnitsDto extends AbstractDto {
    @ApiModelProperty(value = "Измеряемая велечина")
    private String measurementUnit;
    @ApiModelProperty(value = "Обозначение еденицы измерения")
    private String designationUnit;
}
