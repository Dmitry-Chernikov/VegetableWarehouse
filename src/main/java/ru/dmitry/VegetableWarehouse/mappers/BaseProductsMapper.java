package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;

@Mapper (componentModel = "spring")
public interface BaseProductsMapper {
   BaseProductsDto toDto(BaseProducts baseProducts);
   BaseProducts  toEntity(BaseProductsDto baseProductsDto);
}
