package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

@Getter
@Setter
public class ClientsDto extends AbstractDto{

    private String nameClient;
    private String codeUNP;
    private String legalAddress;
    private String telephoneNumber;
    private String fullNameClient;
    private String workingPosition;
}
