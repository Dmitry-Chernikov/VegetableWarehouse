package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.model.Sales;

@Component
public class SalesMapper extends AbstractMapper<Sales, SalesDto>{
    @Autowired
    SalesMapper() {
        super(Sales.class, SalesDto.class);
    }
}
