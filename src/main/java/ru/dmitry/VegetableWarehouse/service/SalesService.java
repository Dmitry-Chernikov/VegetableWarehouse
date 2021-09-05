package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.repo.SalesRepository;

import java.util.List;
@Service
public class SalesService {

    private final SalesRepository salesRepository;

    //Конструктор
    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
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
}
