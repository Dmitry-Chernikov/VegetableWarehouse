package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;

@Component
public class BaseProductsMapper extends AbstractMapper<BaseProducts, BaseProductsDto>{

    @Autowired
    BaseProductsMapper() {
        super(BaseProducts.class, BaseProductsDto.class);
    }
}
