package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.mappers.SalesMapper;
import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.repositories.SalesRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class SalesService {

    private final SalesRepository salesRepository;
    private final SalesMapper mapper;
    @Autowired
    public SalesService(SalesRepository salesRepository, SalesMapper mapper) {
        this.salesRepository = salesRepository;
        this.mapper = mapper;
    }

    //Read id
    public Sales findById(Long id){
        return salesRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Sales> findAll(){
        return salesRepository.findAll();
    }
    //Save one unit
    public Sales save(Sales sales){
        return salesRepository.save(sales);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            salesRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }



    //Read id
    public SalesDto findByIdDto(Long id){
        return mapper.toDto(salesRepository.findById(id).orElse(null));
    }
    //Read All
    public List<SalesDto> findAllDto(){
        List<SalesDto> salesDto = new ArrayList<>();
        for (Sales sales: salesRepository.findAll()) {
            salesDto.add(mapper.toDto(sales));
        }
        return salesDto;
    }
    //Save one unit
    public SalesDto saveDto(SalesDto salesDto){
        return mapper.toDto(salesRepository.save(mapper.toEntity(salesDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            salesRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
