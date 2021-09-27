package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.mappers.SalesMapper;
import ru.dmitry.VegetableWarehouse.repositories.SalesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;
    private final SalesMapper mapper;

    //Read id to Dto
    public SalesDto findById(Long id) {
        return mapper.toDto(salesRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<SalesDto> findAll() {
        return salesRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public SalesDto save(SalesDto salesDto) {
        return mapper.toDto(salesRepository.save(mapper.toEntity(salesDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        salesRepository.deleteById(id);
    }
}
