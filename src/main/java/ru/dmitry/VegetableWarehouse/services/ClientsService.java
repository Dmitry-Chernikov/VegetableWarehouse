package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.dto.EmployeeDto;
import ru.dmitry.VegetableWarehouse.mappers.ClientsMapper;
import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.repositories.ClientsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientsService {

    private final ClientsRepository clientsRepository;
    private final ClientsMapper mapper;

    //Read id
    public Clients findById(Long id) {
        return clientsRepository.findById(id).orElse(null);
    }

    //Read All
    public List<Clients> findAll() {
        return clientsRepository.findAll();
    }

    //Save one unit
    public Clients save(Clients clients) {
        return clientsRepository.save(clients);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            clientsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public ClientsDto findByIdDto(Long id) {
        return mapper.toDto(this.findById(id));
    }

    //Read All to Dto
    public List<ClientsDto> findAllDto() {
        List<ClientsDto> clientsDto = new ArrayList<>();
        for (Clients clients : this.findAll()) {
            clientsDto.add(mapper.toDto(clients));
        }
        return clientsDto;
    }

    //Save one unit and return Dto
    public ClientsDto saveDto(ClientsDto clientsDto) {
        return mapper.toDto(this.save(mapper.toEntity(clientsDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
