package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Employee;
import ru.dmitry.VegetableWarehouse.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String findAll(Model model){
        List<Employee> employee = employeeService.findAll();
        System.out.println(employee.size());
        model.addAttribute("employee", employee);
        return "employee/employee-list";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm (Employee employee){
        return "employee/employee-create";
    }

    @PostMapping("/employee-create")
    public String createEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteBuId(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee-update/{id}")
    public String updateEmployeeForm (@PathVariable("id") Long id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
