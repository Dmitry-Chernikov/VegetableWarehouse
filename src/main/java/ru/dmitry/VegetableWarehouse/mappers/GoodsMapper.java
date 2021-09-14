package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.model.Units;

@Mapper (componentModel = "spring")
public interface GoodsMapper {
    @Mapping(source = "products.nameTypeVegetable",target = "nameTypeVegetable")
    @Mapping(source = "units.designationUnit",target = "designationUnit")
    GoodsDto toDto(Goods goods);
    Goods  toEntity(GoodsDto goodsDto);

}
