package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
@Repository
public interface TypeWarehouseRepository extends JpaRepository<TypeWarehouse, Long> {
}
