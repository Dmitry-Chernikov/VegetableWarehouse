package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
