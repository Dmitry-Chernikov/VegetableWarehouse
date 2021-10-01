package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"База продуктов\"")
public class BaseProductsDto extends AbstractDto{
        @ApiModelProperty(value = "Уникальный идентификатор товара в базе штрих-код")
    private String barcode;
        @ApiModelProperty(value = "Имя типа склада где храниться товар")
    private String nameWarehouse;
        @ApiModelProperty(value = "Имя товара")
    private String varietyName;
//    private Date shelfLife;
//    private String designationUnit;
//    private String manufactureName;
//    private String manufactureCountry;
}
