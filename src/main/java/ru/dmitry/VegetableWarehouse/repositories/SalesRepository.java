package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.Sales;
@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
