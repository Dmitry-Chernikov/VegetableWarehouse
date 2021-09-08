package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Units;

@Component
public class UnitsMapper extends AbstractMapper<Units, UnitsDto>{
    @Autowired
    UnitsMapper() {
        super(Units.class, UnitsDto.class);
    }
}
