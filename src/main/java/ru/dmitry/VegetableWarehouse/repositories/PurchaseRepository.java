package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.Purchase;
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
