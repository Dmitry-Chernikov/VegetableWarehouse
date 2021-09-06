package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.service.ClientsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class ClientsControllerREST {
    private final ClientsService clientsService;

    //Получить все записи
    @GetMapping(path = "/clients")
    public Iterable<Clients> getAllClients() {
        return clientsService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/clients/{id}")
    public ResponseEntity<Clients> getClientsById(@PathVariable("id") Long id) {
        Optional<Clients> clients = Optional.ofNullable(clientsService.findById(id));
        if (clients.isPresent()) {
            return new ResponseEntity<>(clients.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/clients", consumes = "application/json")
    public Clients postClients(@RequestBody Clients clients) {
        return clientsService.save(clients);
    }

    //Метод обновления
    @PutMapping(path = "/clients/{id}")
    public Clients putClients(@RequestBody Clients clients) {
        return clientsService.save(clients);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/clients/{id}", consumes = "application/json")
    public Clients patchClients(@PathVariable("id") Long id, @RequestBody Clients clients) {
        Clients clientsRefresh = clientsService.findById(id);

        if (clients.getNameClient() != null) {
            clientsRefresh.setNameClient(clients.getNameClient());
        }

        if (clients.getCodeUNP() != null) {
            clientsRefresh.setCodeUNP(clients.getCodeUNP());
        }

        if (clients.getLegalAddress() != null) {
            clientsRefresh.setLegalAddress(clients.getLegalAddress());
        }

        if (clients.getTelephoneNumber() != null) {
            clientsRefresh.setTelephoneNumber(clients.getTelephoneNumber());
        }

        if (clients.getFullNameClient() != null) {
            clientsRefresh.setFullNameClient(clients.getFullNameClient());
        }

        if (clients.getWorkingPosition() != null) {
            clientsRefresh.setWorkingPosition(clients.getWorkingPosition());
        }

        return clientsService.save(clientsRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/clients/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteClients(@PathVariable("id") Long id) {
        try {
            clientsService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
