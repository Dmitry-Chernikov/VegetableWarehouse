package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.services.ClientsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@RequiredArgsConstructor
public class ClientsControllerREST {

    private final ClientsService clientsService;

    @GetMapping(path = "/clients")
    public Iterable<ClientsDto> getAllClients() {
        return clientsService.findAllDto();
    }

    @GetMapping(path = "/clients/{id}")
    public ResponseEntity<ClientsDto> getClientsById(@PathVariable("id") Long id) {
        Optional<ClientsDto> clientsDto = Optional.ofNullable(clientsService.findByIdDto(id));
        return clientsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/clients", consumes = "application/json")
    public ClientsDto createClients(@RequestBody ClientsDto clientsDto) {
        return clientsService.saveDto(clientsDto);
    }

    @PutMapping(path = "/clients/{id}")
    public ClientsDto updateClients(@RequestBody ClientsDto clientsDto) {
        return clientsService.saveDto(clientsDto);
    }

    @PatchMapping(path = "/clients/{id}", consumes = "application/json")
    public ClientsDto updateCheckClients(@PathVariable("id") Long id, @RequestBody @Validated ClientsDto clientsDto) {
        ClientsDto clientsDtoRefresh = clientsService.findByIdDto(id);

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

        return clientsService.saveDto(clientsDtoRefresh);
    }

    @DeleteMapping(path = "/clients/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteClients(@PathVariable("id") Long id) {
        clientsService.deleteBuIdDto(id);
    }
}
