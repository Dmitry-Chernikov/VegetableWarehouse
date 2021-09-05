package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Purchase;
import ru.dmitry.VegetableWarehouse.repo.PurchaseRepository;

import java.util.List;
@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    //Конструктор
    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
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
}
