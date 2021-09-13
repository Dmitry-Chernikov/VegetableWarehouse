package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.mappers.SuppliersMapper;
import ru.dmitry.VegetableWarehouse.model.Suppliers;
import ru.dmitry.VegetableWarehouse.repositories.SuppliersRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class SuppliersService {

    private final SuppliersRepository suppliersRepository;
    private final SuppliersMapper mapper;
    @Autowired
    public SuppliersService(SuppliersRepository suppliersRepository, SuppliersMapper mapper) {
        this.suppliersRepository = suppliersRepository;
        this.mapper = mapper;
    }

    //Read id
    public Suppliers findById(Long id){
        return suppliersRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Suppliers> findAll(){
        return suppliersRepository.findAll();
    }
    //Save one unit
    public Suppliers save(Suppliers suppliers){
        return suppliersRepository.save(suppliers);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            suppliersRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }


    //Read id
    public SuppliersDto findByIdDto(Long id){
        return mapper.toDto(suppliersRepository.findById(id).orElse(null));
    }
    //Read All
    public List<SuppliersDto> findAllDto(){
        List<SuppliersDto> suppliersDto = new ArrayList<>();
        for (Suppliers suppliers: suppliersRepository.findAll()) {
            suppliersDto.add(mapper.toDto(suppliers));
        }
        return suppliersDto;
    }
    //Save one unit
    public SuppliersDto saveDto(SuppliersDto suppliersDto){
        return mapper.toDto(suppliersRepository.save(mapper.toEntity(suppliersDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            suppliersRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
