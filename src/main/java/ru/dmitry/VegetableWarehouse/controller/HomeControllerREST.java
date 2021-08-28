package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.repo.BaseProductsRepository;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class HomeControllerREST {
    private BaseProductsRepository baseProductsRepository;

    public HomeControllerREST(BaseProductsRepository baseProductsRepository) {
        this.baseProductsRepository = baseProductsRepository;
    }

    //метод чтения по всей последовательности
    @GetMapping
    public Iterable<BaseProducts> getAllBaseProducts(){
        return baseProductsRepository.findAll();
    }

    //метод чтения по id
    @GetMapping("/{id}")
    public ResponseEntity<BaseProducts>getBaseProductsByld(@PathVariable("id")Long id){
        Optional<BaseProducts> baseProductsMaybe = baseProductsRepository.findById(id);
        if(baseProductsMaybe.isPresent()){
            return new ResponseEntity<>(baseProductsMaybe.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //метод добовления
    @PostMapping(consumes = "application/json")
    public BaseProducts postBaseProducts (@RequestBody BaseProducts baseProducts){
        return baseProductsRepository.save(baseProducts);
    }

    //метод обновления
    @PostMapping("/{id}")
    public BaseProducts putBaseProducts (@RequestBody BaseProducts baseProducts){
        return baseProductsRepository.save(baseProducts);
    }

    //метод обновления с проверкой поля
    @PatchMapping(path = "/{id}",consumes = "application/json")
    public BaseProducts patchBaseProducts(@PathVariable("id") Long id, @RequestBody BaseProducts baseProducts){
        BaseProducts baseProductsRefresh = baseProductsRepository.findById(id).get();

        if(baseProducts.getBarcode() != null){
            baseProductsRefresh.setBarcode(baseProducts.getBarcode());
        }

        if(baseProducts.getTypeWarehouse() != null){
            baseProductsRefresh.setTypeWarehouse(baseProducts.getTypeWarehouse());
        }

        if(baseProducts.getGoods() != null){
            baseProductsRefresh.setGoods(baseProducts.getGoods());
        }

        return baseProductsRepository.save(baseProductsRefresh);
    }

    //метод удаления
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void deleteBaseProducts (@PathVariable("id") Long id){
        try{
            baseProductsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
