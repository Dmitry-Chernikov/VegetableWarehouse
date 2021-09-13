package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.mappers.ClientsMapper;
import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.repositories.ClientsRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;
    private final ClientsMapper mapper;
    @Autowired
    public ClientsService(ClientsRepository clientsRepository, ClientsMapper mapper) {
        this.clientsRepository = clientsRepository;
        this.mapper = mapper;
    }

    //Read id
    public Clients findById(Long id){
        return clientsRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Clients> findAll(){
        return clientsRepository.findAll();
    }
    //Save one unit
    public Clients save(Clients clients){
        return clientsRepository.save(clients);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            clientsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

    //Read id
    public ClientsDto findByIdDto(Long id){
        return mapper.toDto(clientsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<ClientsDto> findAllDto(){
        List<ClientsDto> clientsDto = new ArrayList<>();
        for (Clients clients: clientsRepository.findAll()) {
            clientsDto.add(mapper.toDto(clients));
        }
        return clientsDto;
    }
    //Save one unit
    public ClientsDto saveDto(ClientsDto clientsDto){
        return mapper.toDto(clientsRepository.save(mapper.toEntity(clientsDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            clientsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
