package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.PurchaseMapper;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.model.Purchase;
import ru.dmitry.VegetableWarehouse.repo.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceDto {
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper mapper;
    //Read id
    public PurchaseDto findById(Long id){
        return mapper.toDto(purchaseRepository.findById(id).orElse(null));
    }
    //Read All
    public List<PurchaseDto> findAll(){
        List<PurchaseDto> purchaseDto = new ArrayList<>();
        for (Purchase purchase: purchaseRepository.findAll()) {
            purchaseDto.add(mapper.toDto(purchase));
        }
        return purchaseDto;
    }
    //Save one unit
    public PurchaseDto save(PurchaseDto purchaseDto){
        return mapper.toDto(purchaseRepository.save(mapper.toEntity(purchaseDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            purchaseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
