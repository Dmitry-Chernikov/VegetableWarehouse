package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repo.UnitsRepository;

import java.util.List;

@Service
public class UnitsService {

    private final UnitsRepository unitsRepository;

    //Конструктор
    @Autowired
    public UnitsService(UnitsRepository unitsRepository) {
        this.unitsRepository = unitsRepository;
    }

    //Read id
    public Units findById(Long id){
        return unitsRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Units> findAll(){
        return unitsRepository.findAll();
    }
    //Save one unit
    public Units save(Units units){
        return unitsRepository.save(units);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            unitsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
