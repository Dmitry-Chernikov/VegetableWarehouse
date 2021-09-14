package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Purchase;

@Mapper (componentModel = "spring")
public interface PurchaseMapper{
    @Mapping(source ="baseProducts.goods.varietyName", target = "nameTypeVegetable")
    @Mapping(source ="suppliers.name", target = "name")
    @Mapping(source ="employee.fullName", target = "fullName")
    @Mapping(source ="baseProducts.goods.units.designationUnit", target = "designationUnit")
    PurchaseDto toDto(Purchase purchase);
    Purchase  toEntity(PurchaseDto purchaseDto);
}
