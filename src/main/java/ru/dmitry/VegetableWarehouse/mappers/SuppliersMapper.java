package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Suppliers;

@Mapper (componentModel = "spring")
public interface SuppliersMapper{
    SuppliersDto toDto(Suppliers suppliers);
    Suppliers  toEntity(SuppliersDto  suppliersDto);
}
