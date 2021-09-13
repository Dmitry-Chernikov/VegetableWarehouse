package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Purchase;

@Mapper (componentModel = "spring")
public interface PurchaseMapper{
    PurchaseDto toDto(Purchase purchase);
    Purchase  toEntity(PurchaseDto purchaseDto);
}
