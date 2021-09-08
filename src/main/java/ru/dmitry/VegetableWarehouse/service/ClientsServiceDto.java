package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.ClientsMapper;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.repo.ClientsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientsServiceDto {
    private final ClientsRepository clientsRepository;
    private final ClientsMapper mapper;
    //Read id
    public ClientsDto findById(Long id){
        return mapper.toDto(clientsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<ClientsDto> findAll(){
        List<ClientsDto> clientsDto = new ArrayList<>();
        for (Clients clients: clientsRepository.findAll()) {
            clientsDto.add(mapper.toDto(clients));
        }
        return clientsDto;
    }
    //Save one unit
    public ClientsDto save(ClientsDto clientsDto){
        return mapper.toDto(clientsRepository.save(mapper.toEntity(clientsDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            clientsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
