package ru.dmitry.VegetableWarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersDto extends AbstractDto{
    private Long id;
    private String name;
    private String codeUNP;
    private String legalAddress;
    private String telephoneNumber;
    private String fullName;
    private String workingPosition;
}
