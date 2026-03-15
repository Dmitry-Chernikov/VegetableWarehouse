package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.model.Products;

@Mapper (componentModel = "spring")
public interface ProductsMapper {
    ProductsDto toDto(Products products);
    Products  toEntity(ProductsDto productsDto);
}
