package ru.dmitry.VegetableWarehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Purchase;
import ru.dmitry.VegetableWarehouse.services.BaseProductsService;
import ru.dmitry.VegetableWarehouse.services.EmployeeService;
import ru.dmitry.VegetableWarehouse.services.PurchaseService;
import ru.dmitry.VegetableWarehouse.services.SuppliersService;

@Controller
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final BaseProductsService baseProductsService;
    private final SuppliersService suppliersService;
    private final EmployeeService employeeService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, BaseProductsService baseProductsService, SuppliersService suppliersService, EmployeeService employeeService) {
        this.purchaseService = purchaseService;
        this.baseProductsService = baseProductsService;
        this.suppliersService = suppliersService;
        this.employeeService = employeeService;
    }

    @GetMapping("/purchase")
    public String findAll(Model model){
        model.addAttribute("purchase", purchaseService.findAll());
        return "purchase/purchase-list";
    }

    @GetMapping("/purchase-create")
    public String createPurchaseForm (Model model){
        model.addAttribute("purchase", new Purchase());
        model.addAttribute("baseList", baseProductsService.findAll());
        model.addAttribute("suppliersList", suppliersService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        return "purchase/purchase-create";
    }

    @PostMapping("/purchase-create")
    public String createPurchase(Purchase purchase){
        purchaseService.save(purchase);
        return "redirect:/purchase";
    }

    @GetMapping("purchase-delete/{id}")
    public String deletePurchase(@PathVariable("id") Long id){
        purchaseService.deleteBuId(id);
        return "redirect:/purchase";
    }

    @GetMapping("/purchase-update/{id}")
    public String updatePurchaseForm (@PathVariable("id") Long id, Model model){
        model.addAttribute("baseList", baseProductsService.findAll());
        model.addAttribute("suppliersList", suppliersService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("purchase", purchaseService.findById(id));
        return "purchase/purchase-update";
    }

    @PostMapping("/purchase-update")
    public String updatePurchase(Purchase purchase){
        purchaseService.save(purchase);
        return "redirect:/purchase";
    }
}
