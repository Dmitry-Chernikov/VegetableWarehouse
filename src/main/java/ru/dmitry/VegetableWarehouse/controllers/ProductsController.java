package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.services.ProductsService;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping("/products")
    public String findAll(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products/products-list";
    }

    @GetMapping("/products-create")
    public String createProductsForm(Model model) {
        model.addAttribute("products", new Products());
        return "products/products-create";
    }

    @PostMapping("/products-create")
    public String createProducts(Products products) {
        productsService.save(products);
        return "redirect:/products";
    }

    @GetMapping("products-delete/{id}")
    public String deleteProducts(@PathVariable("id") Long id) {
        productsService.deleteBuId(id);
        return "redirect:/products";
    }

    @GetMapping("/products-update/{id}")
    public String updateProductsForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("products", productsService.findById(id));
        return "products/products-update";
    }

    @PostMapping("/products-update")
    public String updateProducts(Products products) {
        productsService.save(products);
        return "redirect:/products";
    }
}
