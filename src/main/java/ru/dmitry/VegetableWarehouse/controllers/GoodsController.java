package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.services.GoodsService;
import ru.dmitry.VegetableWarehouse.services.ProductsService;
import ru.dmitry.VegetableWarehouse.services.UnitsService;

@Controller
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;
    private final ProductsService productsService;
    private final UnitsService unitsService;

    @GetMapping("/goods")
    public String findAll(Model model) {
        model.addAttribute("goods", goodsService.findAll());
        return "goods/goods-list";
    }

    @GetMapping("/goods-create")
    public String createGoodsForm(Model model) {
        model.addAttribute("goods", new Goods());
        model.addAttribute("productsList", productsService.findAll());
        model.addAttribute("unitsList", unitsService.findAll());
        return "goods/goods-create";
    }

    @PostMapping("/goods-create")
    public String createGoods(Goods goods) {
        goodsService.save(goods);
        return "redirect:/goods";
    }

    @GetMapping("goods-delete/{id}")
    public String deleteGoods(@PathVariable("id") Long id) {
        goodsService.deleteBuId(id);
        return "redirect:/goods";
    }

    @GetMapping("/goods-update/{id}")
    public String updateGoodsForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("productsList", productsService.findAll());
        model.addAttribute("unitsList", unitsService.findAll());
        model.addAttribute("goods", goodsService.findById(id));
        return "goods/goods-update";
    }

    @PostMapping("/goods-update")
    public String updateGoods(Goods goods) {
        goodsService.save(goods);
        return "redirect:/goods";
    }
}
