package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.repository.CrudRepository;
import ru.dmitry.VegetableWarehouse.model.BaseEntity;

//Бин предоставляет класические операции и состовлять операции с данными на лету,
//Сложные запросы без реализации с базой данной
public interface BaseEntityRepository extends CrudRepository<BaseEntity,Long> {
}