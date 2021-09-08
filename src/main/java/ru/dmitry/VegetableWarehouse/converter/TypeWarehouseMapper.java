package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
@Component
public class TypeWarehouseMapper extends AbstractMapper<TypeWarehouse, TypeWarehouseDto>{
    @Autowired
    TypeWarehouseMapper() {
        super(TypeWarehouse.class, TypeWarehouseDto.class);
    }
}
