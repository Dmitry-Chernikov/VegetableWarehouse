package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.model.Purchase;

@Component
public class PurchaseMapper extends AbstractMapper<Purchase, PurchaseDto>{
    @Autowired
    PurchaseMapper() {
        super(Purchase.class, PurchaseDto.class);
    }
}
