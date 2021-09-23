package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.mappers.SalesMapper;
import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.repositories.SalesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;
    private final SalesMapper mapper;

    //Read id
    public Sales findById(Long id) {
        return salesRepository.findById(id).orElse(null);
    }

    //Read All
    public List<Sales> findAll() {
        return salesRepository.findAll();
    }

    //Save one unit
    public Sales save(Sales sales) {
        return salesRepository.save(sales);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            salesRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }


    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public SalesDto findByIdDto(Long id) {
        return mapper.toDto(salesRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<SalesDto> findAllDto() {
        return salesRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public SalesDto saveDto(SalesDto salesDto) {
        return mapper.toDto(this.save(mapper.toEntity(salesDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
