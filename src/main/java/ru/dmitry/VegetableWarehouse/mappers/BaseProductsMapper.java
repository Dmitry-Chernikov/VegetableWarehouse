package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;

@Mapper (componentModel = "spring")
public interface BaseProductsMapper {
   @Mapping(source = "typeWarehouse.nameWarehouse", target = "nameWarehouse")
   @Mapping(source = "goods.varietyName", target = "varietyName")
//   @Mapping(source = "goods.shelfLife", target = "shelfLife")
//   @Mapping(source = "goods.units.designationUnit", target = "designationUnit")
//   @Mapping(source = "goods.manufactureName", target = "manufactureName")
//   @Mapping(source = "goods.manufactureCountry", target = "manufactureCountry")
   BaseProductsDto toDto(BaseProducts baseProducts);
   BaseProducts  toEntity(BaseProductsDto baseProductsDto);
}
