package ru.dmitry.VegetableWarehouse.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitsDto extends AbstractDto {

    private String measurementUnit;
    private String designationUnit;
}
