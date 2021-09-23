package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.mappers.UnitsMapper;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitsService {

    private final UnitsRepository unitsRepository;
    private final UnitsMapper mapper;

    //Read id
    public Units findById(Long id) {
        return unitsRepository.findById(id).orElse(null);
    }

    //Read All
    public List<Units> findAll() {
        return unitsRepository.findAll();
    }

    //Save one unit
    public Units save(Units units) {
        return unitsRepository.save(units);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            unitsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public UnitsDto findByIdDto(Long id) {
        return mapper.toDto(unitsRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<UnitsDto> findAllDto() {
        return unitsRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public UnitsDto saveDto(UnitsDto unitsDto) {
        return mapper.toDto(this.save(mapper.toEntity(unitsDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
