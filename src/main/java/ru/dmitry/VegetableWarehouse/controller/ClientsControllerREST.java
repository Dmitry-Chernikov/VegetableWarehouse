package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.service.ClientsServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class ClientsControllerREST {
    private final ClientsServiceDto clientsServiceDto;

    //Получить все записи
    @GetMapping(path = "/clients")
    public Iterable<ClientsDto> getAllClients() {
        return clientsServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/clients/{id}")
    public ResponseEntity<ClientsDto> getClientsById(@PathVariable("id") Long id) {
        Optional<ClientsDto> clientsDto = Optional.ofNullable(clientsServiceDto.findById(id));
        return clientsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/clients", consumes = "application/json")
    public ClientsDto postClients(@RequestBody ClientsDto clientsDto) {
        return clientsServiceDto.save(clientsDto);
    }

    //Метод обновления
    @PutMapping(path = "/clients/{id}")
    public ClientsDto putClients(@RequestBody ClientsDto clientsDto) {
        return clientsServiceDto.save(clientsDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/clients/{id}", consumes = "application/json")
    public ClientsDto patchClients(@PathVariable("id") Long id, @RequestBody ClientsDto clientsDto) {
        ClientsDto clientsDtoRefresh = clientsServiceDto.findById(id);

        if (clientsDto.getNameClient() != null) {
            clientsDtoRefresh.setNameClient(clientsDto.getNameClient());
        }

        if (clientsDto.getCodeUNP() != null) {
            clientsDtoRefresh.setCodeUNP(clientsDto.getCodeUNP());
        }

        if (clientsDto.getLegalAddress() != null) {
            clientsDtoRefresh.setLegalAddress(clientsDto.getLegalAddress());
        }

        if (clientsDto.getTelephoneNumber() != null) {
            clientsDtoRefresh.setTelephoneNumber(clientsDto.getTelephoneNumber());
        }

        if (clientsDto.getFullNameClient() != null) {
            clientsDtoRefresh.setFullNameClient(clientsDto.getFullNameClient());
        }

        if (clientsDto.getWorkingPosition() != null) {
            clientsDtoRefresh.setWorkingPosition(clientsDto.getWorkingPosition());
        }

        return clientsServiceDto.save(clientsDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/clients/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteClients(@PathVariable("id") Long id) {
        try {
            clientsServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
