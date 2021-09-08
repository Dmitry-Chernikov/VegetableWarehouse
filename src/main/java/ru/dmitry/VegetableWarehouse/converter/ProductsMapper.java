package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.model.Products;

@Component
public class ProductsMapper extends AbstractMapper<Products, ProductsDto>{
    @Autowired
    ProductsMapper() {
        super(Products.class, ProductsDto.class);
    }
}
