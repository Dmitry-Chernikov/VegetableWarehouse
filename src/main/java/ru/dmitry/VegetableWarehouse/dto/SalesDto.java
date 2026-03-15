package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ApiModel("Атрибуты сущности таблицы \"Приходная накладная\"")
public class SalesDto extends AbstractDto{
    @ApiModelProperty(value = "Уникальный идентификатор расходной товарной наклонной")
    private String barcode;
    @ApiModelProperty(value = "Имя товара")
    private String nameTypeVegetable;
    @ApiModelProperty(value = "Количество товара")
    private double countProduct;
    @ApiModelProperty(value = "Измеряемая величина")
    private String designationUnit;
    @ApiModelProperty(value = "Наименование получателя")
    private String clientName;
    @ApiModelProperty(value = "ФИО принявшего клиента товар")
    private String nameClient;
    @ApiModelProperty(value = "ФИО сдавшего товар")
    private String fullName;
    @ApiModelProperty(value = "Дата расхода товара на склад")
    private Date operationDate;
    @ApiModelProperty(value = "Цена товара")
    private double valuePrice;
}
