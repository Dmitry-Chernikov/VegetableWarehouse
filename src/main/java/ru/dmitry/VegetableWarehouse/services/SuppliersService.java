package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.mappers.SuppliersMapper;
import ru.dmitry.VegetableWarehouse.repositories.SuppliersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuppliersService {

    private final SuppliersRepository suppliersRepository;
    private final SuppliersMapper mapper;

    //Read id to Dto
    public SuppliersDto findById(Long id) {
        return mapper.toDto(suppliersRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<SuppliersDto> findAll() {
        return suppliersRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public SuppliersDto save(SuppliersDto suppliersDto) {
        return mapper.toDto(suppliersRepository.save(mapper.toEntity(suppliersDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        suppliersRepository.deleteById(id);
    }
}
