package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.services.ClientsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Клиенты\" и используеться CRUD для базы данных.", hidden = true)
public class ClientsController {

    private final ClientsService clientsService;

    @GetMapping(path = "/clients")
    public Iterable<ClientsDto> getAllClients() {
        return clientsService.findAll();
    }

    @GetMapping(path = "/clients/{id}")
    public ResponseEntity<ClientsDto> getClientsById(@PathVariable("id") Long id) {
        Optional<ClientsDto> clientsDto = Optional.ofNullable(clientsService.findById(id));
        return clientsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/clients")
    public ClientsDto createClients(@RequestBody ClientsDto clientsDto) {
        return clientsService.save(clientsDto);
    }

    @PutMapping(path = "/clients/{id}")
    public ClientsDto updateClients(@RequestBody ClientsDto clientsDto) {
        return clientsService.save(clientsDto);
    }

    @DeleteMapping(path = "/clients/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteClients(@PathVariable("id") Long id) {
        clientsService.deleteById(id);
    }
}
