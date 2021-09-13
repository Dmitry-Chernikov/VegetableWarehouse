package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Sales;

@Mapper (componentModel = "spring")
public interface SalesMapper{
    SalesDto toDto(Sales sales);
    Sales  toEntity(SalesDto salesDto);
}
