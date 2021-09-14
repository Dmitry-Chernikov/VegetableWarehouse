package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.services.EmployeeService;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public String findAll(Model model) {
        model.addAttribute("employee", employeeService.findAll());
        return "employee/employee-list";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/employee-create";
    }

    @PostMapping("/employee-create")
    public String createEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteBuId(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
