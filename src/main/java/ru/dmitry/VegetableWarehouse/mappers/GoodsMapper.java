package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Mapper (componentModel = "spring")
public interface GoodsMapper {
    GoodsDto toDto(Goods goods);
    Goods  toEntity(GoodsDto goodsDto);
}
