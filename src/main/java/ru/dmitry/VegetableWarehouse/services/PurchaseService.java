package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.mappers.PurchaseMapper;
import ru.dmitry.VegetableWarehouse.model.Purchase;
import ru.dmitry.VegetableWarehouse.repositories.PurchaseRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        return mapper.toDto(purchaseRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<PurchaseDto> findAllDto() {
        return purchaseRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
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
