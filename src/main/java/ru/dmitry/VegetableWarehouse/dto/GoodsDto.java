package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Товары\"")
public class GoodsDto extends AbstractDto{
    @ApiModelProperty(value = "Наименование продукта")
    private String nameTypeVegetable;
    @ApiModelProperty(value = "Наименование сорта")
    private String varietyName;
    @ApiModelProperty(value = "Годен до")
    private Date shelfLife;
    @ApiModelProperty(value = "Ед.изм")
    private String designationUnit;
    @ApiModelProperty(value = "Наименование производителя")
    private String manufactureName;
    @ApiModelProperty(value = "Страна происхожден")
    private String manufactureCountry;
}
