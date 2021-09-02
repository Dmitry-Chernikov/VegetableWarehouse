package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.repo.TypeWarehouseRepository;

import java.util.List;
@Service
public class TypeWarehouseService {

    private final TypeWarehouseRepository typeWarehouseRepository;

    //Конструктор
    @Autowired
    public TypeWarehouseService(TypeWarehouseRepository typeWarehouseRepository) {
        this.typeWarehouseRepository = typeWarehouseRepository;
    }

    //Read id
    public TypeWarehouse findById(Long id){
        return typeWarehouseRepository.findById(id).orElse(null);
    }
    //Read All
    public List<TypeWarehouse> findAll(){
        return typeWarehouseRepository.findAll();
    }
    //Save one unit
    public TypeWarehouse saveUnits(TypeWarehouse typeWarehouse){
        return typeWarehouseRepository.save(typeWarehouse);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            typeWarehouseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
