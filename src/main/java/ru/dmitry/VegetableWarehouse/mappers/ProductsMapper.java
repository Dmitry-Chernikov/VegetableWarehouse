package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Products;

@Mapper (componentModel = "spring")
public interface ProductsMapper {
    ProductsDto toDto(Products products);
    Products  toEntity(ProductsDto productsDto);
}
