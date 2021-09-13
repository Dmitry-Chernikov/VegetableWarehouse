package ru.dmitry.VegetableWarehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.services.BaseProductsService;
import ru.dmitry.VegetableWarehouse.services.GoodsService;
import ru.dmitry.VegetableWarehouse.services.TypeWarehouseService;

@Controller
@RequestMapping("/")
public class BaseProductsController {

    private final BaseProductsService  baseProductsService;
    private final TypeWarehouseService typeWarehouseService;
    private final GoodsService goodsService;

    @Autowired
    public BaseProductsController(BaseProductsService baseProductsService, TypeWarehouseService typeWarehouseService, GoodsService goodsService) {
        this.baseProductsService = baseProductsService;
        this.typeWarehouseService = typeWarehouseService;
        this.goodsService = goodsService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("baseProducts", baseProductsService.findAll());
        return "base-products/base-products-list";
    }

    @GetMapping("/base-products-create")
    public String createBaseProductsForm (Model model){
        model.addAttribute("baseProducts", new BaseProducts());
        model.addAttribute("typeWarehouseList", typeWarehouseService.findAll());
        model.addAttribute("goodsList", goodsService.findAll());
        return "base-products/base-products-create";
    }

    @PostMapping("/base-products-create")
    public String createBaseProducts(BaseProducts baseProducts){
        baseProductsService.save(baseProducts);
        return "redirect:/";
    }

    @GetMapping("base-products-delete/{id}")
    public String deleteBaseProducts(@PathVariable("id") Long id){
        baseProductsService.deleteBuId(id);
        return "redirect:/";
    }

    @GetMapping("/base-products-update/{id}")
    public String updateBaseProductsForm (@PathVariable("id") Long id, Model model){
        model.addAttribute("baseProducts", baseProductsService.findById(id));
        model.addAttribute("typeWarehouseList", typeWarehouseService.findAll());
        model.addAttribute("goodsList", goodsService.findAll());
        return "base-products/base-products-update";
    }

    @PostMapping("/base-products-update")
    public String updateBaseProducts(BaseProducts baseProducts){
        baseProductsService.save(baseProducts);
        return "redirect:/";
    }
}
