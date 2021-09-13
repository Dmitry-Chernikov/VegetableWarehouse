package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.Goods;
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
