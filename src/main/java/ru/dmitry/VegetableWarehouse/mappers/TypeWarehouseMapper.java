package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;

@Mapper (componentModel = "spring")
public interface TypeWarehouseMapper{
    TypeWarehouseDto toDto(TypeWarehouse typeWarehouse);
    TypeWarehouse  toEntity(TypeWarehouseDto typeWarehouseDto);
}
