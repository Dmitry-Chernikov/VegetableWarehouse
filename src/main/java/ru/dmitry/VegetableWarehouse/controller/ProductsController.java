package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.service.ProductsService;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;
    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String findAll(Model model){
        List<Products> products = productsService.findAll();
        model.addAttribute("products", products);
        return "products/products-list";
    }

    @GetMapping("/products-create")
    public String createProductsForm (Products products){
        return "products/products-create";
    }

    @PostMapping("/products-create")
    public String createProducts(Products products){
        productsService.save(products);
        return "redirect:/products";
    }

    @GetMapping("products-delete/{id}")
    public String deleteProducts(@PathVariable("id") Long id){
        productsService.deleteBuId(id);
        return "redirect:/products";
    }

    @GetMapping("/products-update/{id}")
    public String updateProductsForm (@PathVariable("id") Long id, Model model){
        Products products = productsService.findById(id);
        model.addAttribute("products", products);
        return "products/products-update";
    }

    @PostMapping("/products-update")
    public String updateProducts(Products products){
        productsService.save(products);
        return "redirect:/products";
    }
}