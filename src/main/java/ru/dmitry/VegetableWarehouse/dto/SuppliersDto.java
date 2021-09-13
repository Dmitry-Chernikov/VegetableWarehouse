package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersDto extends AbstractDto{

    private String name;
    private String codeUNP;
    private String legalAddress;
    private String telephoneNumber;
    private String fullName;
    private String workingPosition;
}
