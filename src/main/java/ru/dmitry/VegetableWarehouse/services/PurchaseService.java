package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.mappers.PurchaseMapper;
import ru.dmitry.VegetableWarehouse.model.Purchase;
import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.repositories.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper mapper;

    //Read id
    public Purchase findById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    //Read All
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    //Save one unit
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            purchaseRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }


    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public PurchaseDto findByIdDto(Long id) {
        return mapper.toDto(this.findById(id));
    }

    //Read All to Dto
    public List<PurchaseDto> findAllDto() {
        List<PurchaseDto> purchaseDto = new ArrayList<>();
        for (Purchase purchase : this.findAll()) {
            purchaseDto.add(mapper.toDto(purchase));
        }
        return purchaseDto;
    }

    //Save one unit and return Dto
    public PurchaseDto saveDto(PurchaseDto purchaseDto) {
        return mapper.toDto(this.save(mapper.toEntity(purchaseDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
