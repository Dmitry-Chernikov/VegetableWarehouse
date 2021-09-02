package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;

//Бин предоставляет класические операции и состовлять операции с данными на лету,
//Сложные запросы без реализации с базой данной
public interface BaseProductsRepository extends JpaRepository<BaseProducts,Long> {
} 