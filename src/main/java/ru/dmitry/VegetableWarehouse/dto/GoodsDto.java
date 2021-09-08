package ru.dmitry.VegetableWarehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDto extends AbstractDto{
    private Long id;
    private Long productsId;
    private String varietyName;
    private Date shelfLife;
    private Long unitsId;
    private String manufactureName;
    private String manufactureCountry;
}
