package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.model.Clients;

@Mapper (componentModel = "spring")
public interface ClientsMapper{
    ClientsDto toDto(Clients clients);
    Clients  toEntity(ClientsDto clientsDto);
}
