package ru.dmitry.VegetableWarehouse.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.model.Clients;

@Component
public class ClientsMapper extends AbstractMapper<Clients, ClientsDto> {
    @Autowired
    ClientsMapper() {
        super(Clients.class, ClientsDto.class);
    }
}
