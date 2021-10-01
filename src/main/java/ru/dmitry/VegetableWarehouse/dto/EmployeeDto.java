package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ApiModel("Атрибуты сущьности таблицы \"Сотрудники\"")
public class EmployeeDto extends AbstractDto{
    @ApiModelProperty(value = "ФИО сотрудника")
    private String fullName;
    @ApiModelProperty(value = "Дата рождения сотрудника")
    private Date dateBirth;
    @ApiModelProperty(value = "Должность сотрудника")
    private String position;
    @ApiModelProperty(value = "Адрес проживания")
    private String accommodationAddress;
    @ApiModelProperty(value = "Телефон домашний")
    private String telephoneHome;
    @ApiModelProperty(value = "Телефон мобильный")
    private String telephoneMobil;
}
