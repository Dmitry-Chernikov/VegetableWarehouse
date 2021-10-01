package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Клиенты\"")
public class ClientsDto extends AbstractDto{
    @ApiModelProperty(value = "Наименование получателя")
    private String nameClient;
    @ApiModelProperty(value = "Код учётного номера плательщика УНП")
    private String codeUNP;
    @ApiModelProperty(value = "Юридический адрес")
    private String legalAddress;
    @ApiModelProperty(value = "Телефон")
    private String telephoneNumber;
    @ApiModelProperty(value = "Контактное лицо")
    private String fullNameClient;
    @ApiModelProperty(value = "Должность")
    private String workingPosition;
}
