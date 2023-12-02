package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.SneakerDTO;
import com.android.android.Service.SneakerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/sneaker"})
public class SneakerController {
    private final SneakerService sneakerService;

    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @PostMapping({"/create"})
    public SneakerDTO create(@RequestBody SneakerDTO sneakerDTO) {
        return new SneakerDTO(this.sneakerService.insert(sneakerDTO.getBrand(), sneakerDTO.getModel(), sneakerDTO.getDescription(), sneakerDTO.getPrice(), sneakerDTO.getPhoto()));
    }
}