package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Поставщики\"")
public class SuppliersDto extends AbstractDto{
    @ApiModelProperty(value = "Наименование поставщика")
    private String name;
    @ApiModelProperty(value = "Код учётного номера плательщика УН")
    private String codeUNP;
    @ApiModelProperty(value = "Юридический адрес")
    private String legalAddress;
    @ApiModelProperty(value = "Телефон")
    private String telephoneNumber;
    @ApiModelProperty(value = "Контактное лицо")
    private String fullName;
    @ApiModelProperty(value = "Должность")
    private String workingPosition;
}
