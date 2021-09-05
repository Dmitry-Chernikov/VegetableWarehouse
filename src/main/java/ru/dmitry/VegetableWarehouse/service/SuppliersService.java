package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Suppliers;
import ru.dmitry.VegetableWarehouse.repo.SuppliersRepository;

import java.util.List;
@Service
public class SuppliersService {

    private final SuppliersRepository suppliersRepository;

    //Конструктор
    @Autowired
    public SuppliersService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
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
}
