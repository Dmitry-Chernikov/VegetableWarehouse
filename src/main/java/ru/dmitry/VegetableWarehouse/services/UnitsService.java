package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.mappers.UnitsMapper;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@NoArgsConstructor
@RequiredArgsConstructor
public class UnitsService {

    private final UnitsRepository unitsRepository;
    private final UnitsMapper mapper;

    //Read id to Dto
    public UnitsDto findById(Long id) {
        return mapper.toDto(unitsRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<UnitsDto> findAll() {
        return unitsRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public UnitsDto save(UnitsDto unitsDto) {
        return mapper.toDto(unitsRepository.save(mapper.toEntity(unitsDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        unitsRepository.deleteById(id);
    }
}
