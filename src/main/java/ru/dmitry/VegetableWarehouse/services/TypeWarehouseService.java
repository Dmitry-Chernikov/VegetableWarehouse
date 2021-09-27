package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.mappers.TypeWarehouseMapper;
import ru.dmitry.VegetableWarehouse.repositories.TypeWarehouseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeWarehouseService {

    private final TypeWarehouseRepository typeWarehouseRepository;
    private final TypeWarehouseMapper mapper;

    //Read id to Dto
    public TypeWarehouseDto findById(Long id) {
        return mapper.toDto(typeWarehouseRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<TypeWarehouseDto> findAll() {
        return typeWarehouseRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public TypeWarehouseDto save(TypeWarehouseDto typeWarehouseDto) {
        return mapper.toDto(typeWarehouseRepository.save(mapper.toEntity(typeWarehouseDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        typeWarehouseRepository.deleteById(id);
    }
}
