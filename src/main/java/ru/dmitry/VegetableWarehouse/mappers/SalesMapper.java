package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Sales;

@Mapper (componentModel = "spring")
public interface SalesMapper{
    @Mapping(source ="baseProducts.goods.varietyName", target = "nameTypeVegetable")
    @Mapping(source ="clients.nameClient", target = "nameClient")
    @Mapping(source ="employee.fullName", target = "fullName")
    @Mapping(source ="baseProducts.goods.units.designationUnit", target = "designationUnit")
    SalesDto toDto(Sales sales);
    Sales  toEntity(SalesDto salesDto);
}
