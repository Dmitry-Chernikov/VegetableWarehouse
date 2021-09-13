package ru.dmitry.VegetableWarehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.services.BaseProductsService;
import ru.dmitry.VegetableWarehouse.services.ClientsService;
import ru.dmitry.VegetableWarehouse.services.EmployeeService;
import ru.dmitry.VegetableWarehouse.services.SalesService;

@Controller
public class SalesController {

    private final SalesService salesService;
    private final BaseProductsService baseProductsService;
    private final ClientsService clientsService;
    private final EmployeeService employeeService;

    @Autowired
    public SalesController(SalesService salesService, BaseProductsService baseProductsService, ClientsService clientsService, EmployeeService employeeService) {
        this.salesService = salesService;
        this.baseProductsService = baseProductsService;
        this.clientsService = clientsService;
        this.employeeService = employeeService;
    }

    @GetMapping("/sales")
    public String findAll(Model model){
        model.addAttribute("sales", salesService.findAll());
        return "sales/sales-list";
    }

    @GetMapping("/sales-create")
    public String createSalesForm (Model model){
        model.addAttribute("sales", new Sales());
        model.addAttribute("baseList", baseProductsService.findAll());
        model.addAttribute("clientsList", clientsService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        return "sales/sales-create";
    }

    @PostMapping("/sales-create")
    public String createSales(Sales sales){
        salesService.save(sales);
        return "redirect:/sales";
    }

    @GetMapping("sales-delete/{id}")
    public String deleteSales(@PathVariable("id") Long id){
        salesService.deleteBuId(id);
        return "redirect:/sales";
    }

    @GetMapping("/sales-update/{id}")
    public String updateSalesForm (@PathVariable("id") Long id, Model model){
        model.addAttribute("baseList", baseProductsService.findAll());
        model.addAttribute("clientsList", clientsService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("sales", salesService.findById(id));
        return "sales/sales-update";
    }

    @PostMapping("/sales-update")
    public String updateSales(Sales sales){
        salesService.save(sales);
        return "redirect:/sales";
    }


}
