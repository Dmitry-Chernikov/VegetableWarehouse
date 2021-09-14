package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.services.ClientsService;

@Controller
@RequiredArgsConstructor
public class ClientsController {

    private final ClientsService clientsService;

    @GetMapping("/clients")
    public String findAll(Model model) {
        model.addAttribute("clients", clientsService.findAll());
        return "clients/clients-list";
    }

    @GetMapping("/clients-create")
    public String createClientsForm(Model model) {
        model.addAttribute("clients", new Clients());
        return "clients/clients-create";
    }

    @PostMapping("/clients-create")
    public String createClients(Clients clients) {
        clientsService.save(clients);
        return "redirect:/clients";
    }

    @GetMapping("clients-delete/{id}")
    public String deleteClients(@PathVariable("id") Long id) {
        clientsService.deleteBuId(id);
        return "redirect:/clients";
    }

    @GetMapping("/clients-update/{id}")
    public String updateClientsForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("clients", clientsService.findById(id));
        return "clients/clients-update";
    }

    @PostMapping("/clients-update")
    public String updateClients(Clients clients) {
        clientsService.save(clients);
        return "redirect:/clients";
    }
}
