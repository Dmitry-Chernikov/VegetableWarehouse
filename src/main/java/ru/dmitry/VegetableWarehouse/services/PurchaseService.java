package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.mappers.PurchaseMapper;
import ru.dmitry.VegetableWarehouse.model.Purchase;
import ru.dmitry.VegetableWarehouse.repositories.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper mapper;
    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository, PurchaseMapper mapper) {
        this.purchaseRepository = purchaseRepository;
        this.mapper = mapper;
    }

    //Read id
    public Purchase findById(Long id){
        return purchaseRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Purchase> findAll(){
        return purchaseRepository.findAll();
    }
    //Save one unit
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            purchaseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }


    //Read id
    public PurchaseDto findByIdDto(Long id){
        return mapper.toDto(purchaseRepository.findById(id).orElse(null));
    }
    //Read All
    public List<PurchaseDto> findAllDto(){
        List<PurchaseDto> purchaseDto = new ArrayList<>();
        for (Purchase purchase: purchaseRepository.findAll()) {
            purchaseDto.add(mapper.toDto(purchase));
        }
        return purchaseDto;
    }
    //Save one unit
    public PurchaseDto saveDto(PurchaseDto purchaseDto){
        return mapper.toDto(purchaseRepository.save(mapper.toEntity(purchaseDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            purchaseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
