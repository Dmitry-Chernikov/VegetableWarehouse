package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.model.Goods;

@Mapper (componentModel = "spring")
public interface GoodsMapper {
    @Mapping(source = "products.nameTypeVegetable",target = "nameTypeVegetable")
    @Mapping(source = "units.designationUnit",target = "designationUnit")
    GoodsDto toDto(Goods goods);
    Goods  toEntity(GoodsDto goodsDto);

}
