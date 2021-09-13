package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.mappers.TypeWarehouseMapper;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.repositories.TypeWarehouseRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class TypeWarehouseService {

    private final TypeWarehouseRepository typeWarehouseRepository;
    private final TypeWarehouseMapper mapper;
    @Autowired
    public TypeWarehouseService(TypeWarehouseRepository typeWarehouseRepository, TypeWarehouseMapper mapper) {
        this.typeWarehouseRepository = typeWarehouseRepository;
        this.mapper = mapper;
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
    public TypeWarehouse save(TypeWarehouse typeWarehouse){
        return typeWarehouseRepository.save(typeWarehouse);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            typeWarehouseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }



    //Read id
    public TypeWarehouseDto findByIdDto(Long id){
        return mapper.toDto(typeWarehouseRepository.findById(id).orElse(null));
    }
    //Read All
    public List<TypeWarehouseDto> findAllDto(){
        List<TypeWarehouseDto> typeWarehouseDto = new ArrayList<>();
        for (TypeWarehouse typeWarehouse: typeWarehouseRepository.findAll()) {
            typeWarehouseDto.add(mapper.toDto(typeWarehouse));
        }
        return typeWarehouseDto;
    }
    //Save one unit
    public TypeWarehouseDto saveDto(TypeWarehouseDto typeWarehouseDto){
        return mapper.toDto(typeWarehouseRepository.save(mapper.toEntity(typeWarehouseDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            typeWarehouseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
