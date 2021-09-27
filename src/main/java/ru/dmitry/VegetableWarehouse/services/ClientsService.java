package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.mappers.ClientsMapper;
import ru.dmitry.VegetableWarehouse.repositories.ClientsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientsService {

    private final ClientsRepository clientsRepository;
    private final ClientsMapper mapper;


    //Read id to Dto
    public ClientsDto findById(Long id) {
        return mapper.toDto(clientsRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<ClientsDto> findAll() {
        return clientsRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public ClientsDto save(ClientsDto clientsDto) {
        return mapper.toDto(clientsRepository.save(mapper.toEntity(clientsDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        clientsRepository.deleteById(id);
    }
}
