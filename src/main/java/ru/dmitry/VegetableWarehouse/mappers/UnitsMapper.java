package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Units;

@Mapper (componentModel = "spring")
public interface UnitsMapper{
    UnitsDto toDto(Units units);
    Units  toEntity(UnitsDto unitsDto);
}
