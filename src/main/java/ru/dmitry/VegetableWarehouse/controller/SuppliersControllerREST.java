package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Suppliers;
import ru.dmitry.VegetableWarehouse.service.SuppliersService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor //
public class SuppliersControllerREST {

    private final SuppliersService suppliersService;

    //Получить все записи
    @GetMapping("/suppliers")
    public Iterable<Suppliers> getAllSuppliers(){
        return suppliersService.findAll();
    }

    //Получить записи по id
    @GetMapping("/suppliers/{id}")
    public ResponseEntity<Suppliers> getSuppliersById(@PathVariable("id") Long id){
        Optional<Suppliers> suppliers = Optional.ofNullable(suppliersService.findById(id));
        if(suppliers.isPresent()){
            return new ResponseEntity<>(suppliers.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(consumes = "application/json", path = "/suppliers")
    public Suppliers postSuppliers(@RequestBody Suppliers suppliers){
        return suppliersService.save(suppliers);
    }

    //Метод обновления
    @PutMapping("/suppliers/{id}")
    public Suppliers putSuppliers(@RequestBody Suppliers suppliers){
        return suppliersService.save(suppliers);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/suppliers/{id}",consumes = "application/json")
    public Suppliers patchSuppliers(@PathVariable("id") Long id, @RequestBody Suppliers suppliers){
        Suppliers suppliersRefresh = suppliersService.findById(id);

        if(suppliers.getName() != null){
            suppliersRefresh.setName(suppliers.getName());
        }

        if(suppliers.getCodeUNP() != null){
            suppliersRefresh.setCodeUNP(suppliers.getCodeUNP());
        }

        if(suppliers.getLegalAddress() != null){
            suppliersRefresh.setLegalAddress(suppliers.getLegalAddress());
        }

        if(suppliers.getTelephoneNumber() != null){
            suppliersRefresh.setTelephoneNumber(suppliers.getTelephoneNumber());
        }

        if(suppliers.getFullName() != null){
            suppliersRefresh.setFullName(suppliers.getFullName());
        }

        if(suppliers.getWorkingPosition() != null){
            suppliersRefresh.setWorkingPosition(suppliers.getWorkingPosition());
        }

        return suppliersService.save(suppliersRefresh);
    }

    //Метод удаления
    @DeleteMapping("/suppliers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSuppliers (@PathVariable("id") Long id){
        try{
            suppliersService.deleteBuId(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
