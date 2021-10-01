package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Расходная накладная\"")
public class PurchaseDto extends AbstractDto{
    @ApiModelProperty(value = "Уникальный идентификатор приходной товарной наклодной")
    private String barcode;
    @ApiModelProperty(value = "Имя товара")
    private String nameTypeVegetable;
    @ApiModelProperty(value = "Количество товара")
    private double countProduct;
    @ApiModelProperty(value = "Измеряемая велечина")
    private String designationUnit;
    @ApiModelProperty(value = "Наименование поставщика")
    private String suppliersName;
    @ApiModelProperty(value = "ФИО сдавшего товар")
    private String name;
    @ApiModelProperty(value = "ФИО прнинявшего товар")
    private String fullName;
    @ApiModelProperty(value = "Дата прихода товара на склад")
    private Date operationDate;
    @ApiModelProperty(value = "Цена товара")
    private double valuePrice;
}
