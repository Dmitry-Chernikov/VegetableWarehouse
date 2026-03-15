package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.model.Suppliers;

@Mapper (componentModel = "spring")
public interface SuppliersMapper{
    SuppliersDto toDto(Suppliers suppliers);
    Suppliers  toEntity(SuppliersDto  suppliersDto);
}
