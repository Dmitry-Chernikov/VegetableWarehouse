package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.repo.BaseEntityRepository;


@Controller //помечаем что класс будет контроллером
@RequestMapping("/") //По какому пути этот метод будет срабатывать
public class HomeController {

/*    private BaseEntityRepository baseEntityRepository;
    //три типа внедрения зависимостей, через поле, черз Setter, конструктор
    //spring context вставляет необходимые зависимости
    @Autowired //Авто связь это на всякий случай
    public HomeController(BaseEntityRepository baseEntityRepository) {
        this.baseEntityRepository = baseEntityRepository;
    }

    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("base", baseEntityRepository.findAll());
        model.addAttribute("newVegetable",new BaseProducts());
        return "index";
    }

    @PostMapping
    public String createGoods(BaseProducts vegetable){
        baseEntityRepository.save(vegetable);
        return "redirect:/";
    }*/
}
