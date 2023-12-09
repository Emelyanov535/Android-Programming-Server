package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.BasketDTO;
import com.android.android.Controller.DTO.BasketSneakerDTO;
import com.android.android.Controller.DTO.SneakerDTO;
import com.android.android.Model.BasketSneaker;
import com.android.android.Model.BasketSneakerId;
import com.android.android.Service.BasketService;
import com.android.android.Service.SneakerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/basket"})
public class BasketController {

    private final BasketService basketService;
    private final SneakerService sneakerService;

    public BasketController(BasketService basketService, SneakerService sneakerService) {
        this.basketService = basketService;
        this.sneakerService = sneakerService;
    }

    @PostMapping("/createBasketSneaker")
    public BasketSneakerDTO createBasketSneaker(@RequestBody BasketSneakerDTO basketSneakerDTO){
        return new BasketSneakerDTO(basketService.createSneakerToBasket(new BasketSneaker(
                basketService.getById(basketSneakerDTO.getBasketId()),
                sneakerService.findSneaker(basketSneakerDTO.getSneakerId()),
                basketSneakerDTO.getQuantity())));
    }

    @GetMapping("/getUserBasket/{id}")
    public Long getUserBasket(@PathVariable("id") Long id){
        return basketService.getUserBasket(id).getId();
    }

    @GetMapping("/getUserBasketSneakers/{id}")
    public List<SneakerDTO> getUserBasketSneakers(@PathVariable("id") Long id) {
        return basketService.getUserBasketSneakers(id)
                .stream()
                .map(basketSneaker -> new SneakerDTO(basketSneaker.getSneaker()))
                .distinct()
                .toList();
    }

    @GetMapping("/getQuantity/{basketId}/{sneakerId}")
    public Integer getQuantity(@PathVariable("basketId") Long basketId,
                               @PathVariable("sneakerId") Long sneakerId
    ){
        return basketService.getQuantity(basketId, sneakerId);
    }

    @PutMapping("/incrementQuantity/{basketId}/{sneakerId}")
    public void incrementQuantity(@PathVariable("basketId") Long basketId,
                                  @PathVariable("sneakerId") Long sneakerId
    ){
        basketService.incrementQuantity(basketId, sneakerId);
    }

    @PutMapping("/decrementQuantity/{basketId}/{sneakerId}")
    public void decrementQuantity(@PathVariable("basketId") Long basketId,
                                  @PathVariable("sneakerId") Long sneakerId
    ){
        basketService.decrementQuantity(basketId, sneakerId);
    }

    @GetMapping("/getSneaker/{basketId}/{sneakerId}")
    public boolean getSneaker(@PathVariable("basketId") Long basketId,
                                       @PathVariable("sneakerId") Long sneakerId
    ){
        return basketService.getSneaker(basketId, sneakerId);
    }

    @GetMapping("/removeSneaker/{basketId}/{sneakerId}")
    public void removeSneakerFromBasket(@PathVariable("basketId") Long basketId,
                                        @PathVariable("sneakerId") Long sneakerId
    ){
        basketService.removeSneakerFromBasket(basketId, sneakerId);
    }
}
