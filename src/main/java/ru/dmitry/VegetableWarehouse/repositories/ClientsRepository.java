package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.Clients;
@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
