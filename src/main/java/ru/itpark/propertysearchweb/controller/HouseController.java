package ru.itpark.propertysearchweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.propertysearchweb.domain.House;
import ru.itpark.propertysearchweb.service.HouseService;
import ru.itpark.propertysearchweb.service.SQLHandler;

@Controller
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("houses",houseService.getAllHouse());
        return "index";
    }

    @PostMapping
    public String index(Model model, @RequestParam int id, @RequestParam String area,@RequestParam int price){
        SQLHandler.connect();
        houseService.add(new House(id, area, price));
        SQLHandler.addProperty(id, area, price);
        SQLHandler.disconnect();
        model.addAttribute("houses",houseService.getAllHouse());
        return "index";
    }
}
