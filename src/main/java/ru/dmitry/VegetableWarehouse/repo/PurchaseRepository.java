package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
