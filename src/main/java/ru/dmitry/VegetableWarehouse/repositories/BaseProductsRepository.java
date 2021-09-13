package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;

//Бин предоставляет класические операции и состовлять операции с данными на лету,
//Сложные запросы без реализации с базой данной
@Repository
public interface BaseProductsRepository extends JpaRepository<BaseProducts,Long> {
} 