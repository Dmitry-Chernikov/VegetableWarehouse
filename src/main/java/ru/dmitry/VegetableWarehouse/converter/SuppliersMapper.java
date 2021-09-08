package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.model.Suppliers;

@Component
public class SuppliersMapper extends AbstractMapper<Suppliers, SuppliersDto>{
    @Autowired
    SuppliersMapper() {
        super(Suppliers.class, SuppliersDto.class);
    }
}
