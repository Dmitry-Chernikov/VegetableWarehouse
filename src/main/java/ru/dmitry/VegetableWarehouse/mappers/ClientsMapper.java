package ru.dmitry.VegetableWarehouse.mappers;

import org.mapstruct.Mapper;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.model.Clients;

@Mapper (componentModel = "spring")
public interface ClientsMapper{
    ClientsDto toDto(Clients clients);
    Clients  toEntity(ClientsDto clientsDto);
}
