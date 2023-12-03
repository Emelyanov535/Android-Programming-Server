package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.SneakerDTO;
import com.android.android.Model.Sneaker;
import com.android.android.Service.SneakerService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/sneaker"})
public class SneakerController {
    private final SneakerService sneakerService;

    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @PostMapping({"/create"})
    public SneakerDTO create(@RequestBody SneakerDTO sneakerDTO) {
        return new SneakerDTO(sneakerService.insert(sneakerDTO.getBrand(), sneakerDTO.getModel(), sneakerDTO.getDescription(), sneakerDTO.getPrice(), sneakerDTO.getPhoto()));
    }

    @PutMapping("/update/{id}")
    public SneakerDTO update(@PathVariable Long id, @RequestBody SneakerDTO sneakerDTO){
        return new SneakerDTO(sneakerService.update(id, sneakerDTO.getBrand(), sneakerDTO.getModel(), sneakerDTO.getDescription(), sneakerDTO.getPrice(), sneakerDTO.getPhoto()));
    }

    @DeleteMapping("/delete/{id}")
    public SneakerDTO delete(@PathVariable Long id){
        return new SneakerDTO(sneakerService.delete(id));
    }

    @GetMapping("/get/{id}")
    public SneakerDTO get(@PathVariable Long id){
        return new SneakerDTO(sneakerService.findSneaker(id));
    }

    @GetMapping("/getAll")
    public Page<SneakerDTO> getAll(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "5") int size) {
        return sneakerService.getAllSneakerPaged(page, size)
                .map(sneaker -> new SneakerDTO(new Sneaker(sneaker.getBrand(), sneaker.getModel(), sneaker.getDescription(), sneaker.getPrice(), sneaker.getPhoto())));
    }
}