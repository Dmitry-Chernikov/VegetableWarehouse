package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.repo.BaseProductsRepository;


@Controller //помечаем что класс будет контроллером
@RequestMapping(value = "/home")
public class HomeController {

    private BaseProductsRepository baseProductsRepository;
    //три типа внедрения зависимостей, через поле, черз Setter, конструктор
    //spring context вставляет необходимые зависимости
    @Autowired //Авто связь это на всякий случай
    public HomeController(BaseProductsRepository baseProductsRepository) {
        this.baseProductsRepository = baseProductsRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("baseProducts", baseProductsRepository.findAll());
        model.addAttribute("newBaseProducts",new BaseProducts());
        return "index";
    }

    @PostMapping("/")
    public String createGoods(BaseProducts baseProducts){
        baseProductsRepository.save(baseProducts);
        return "redirect:/";
    }
}
