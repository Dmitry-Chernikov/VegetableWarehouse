package ru.dmitry.VegetableWarehouse.clientGrpc;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UnitsClientController {

    private UnitsClientService unitsClientService;

    @Autowired
    public UnitsClientController(UnitsClientService unitsClientService) {
        this.unitsClientService = unitsClientService;
    }

    @RequestMapping("/grpc")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name) {
        return unitsClientService.sendMessage(name);
    }
}
