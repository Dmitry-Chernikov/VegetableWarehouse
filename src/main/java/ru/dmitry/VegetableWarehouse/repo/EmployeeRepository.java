package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
