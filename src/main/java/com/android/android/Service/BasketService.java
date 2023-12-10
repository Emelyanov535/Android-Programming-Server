package com.android.android.Service;

import com.android.android.Model.Basket;
import com.android.android.Model.BasketSneaker;
import com.android.android.Model.Sneaker;
import com.android.android.Model.User;
import com.android.android.Repository.BasketRepository;
import com.android.android.Repository.BasketSneakerRepository;
import com.android.android.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {
    private final BasketRepository basketRepository;
    private final BasketSneakerRepository basketSneakerRepository;
    private final UserService userService;

    public BasketService(BasketRepository basketRepository, BasketSneakerRepository basketSneakerRepository, UserService userRepository) {
        this.basketRepository = basketRepository;
        this.basketSneakerRepository = basketSneakerRepository;
        this.userService = userRepository;
    }

    @Transactional
    public Basket getById(Long id){
        return basketRepository.getReferenceById(id);
    }

    @Transactional
    public Basket create(User user){
        Basket basket = new Basket(user);
        user.setBasket(basket);
        return basketRepository.save(basket);
    }

    @Transactional
    public BasketSneaker createSneakerToBasket(BasketSneaker basketSneaker){
        return basketSneakerRepository.save(basketSneaker);
    }

    @Transactional
    public Basket getUserBasket(Long id){
        User user = userService.getUserById(id);
        Basket basket = user.getBasket();
        return basket;
    }

    @Transactional
    public List<BasketSneaker> getUserBasketSneakers(Long id){
        User user = userService.getUserById(id);
        Basket basket = user.getBasket();
        List<BasketSneaker> sneakers = basket.getBasketSneakers();
        return sneakers;
    }

    @Transactional
    public int getQuantity(Long basketId, Long sneakerId){
        Basket basket = basketRepository.getReferenceById(basketId);
        List<BasketSneaker> basketSneakers = basket.getBasketSneakers();

        Optional<BasketSneaker> matchingBasketSneaker = basketSneakers.stream()
                .filter(basketSneaker -> basketSneaker.getSneaker().getId().equals(sneakerId))
                .findFirst();
        return matchingBasketSneaker.map(BasketSneaker::getQuantity).orElse(0);
    }

    @Transactional
    public void incrementQuantity(Long basketId, Long sneakerId){
        basketRepository.incrementSneakerQuantity(basketId, sneakerId);
    }

    @Transactional
    public void decrementQuantity(Long basketId, Long sneakerId){
        basketRepository.decrementSneakerQuantity(basketId, sneakerId);
    }

    @Transactional
    public boolean getSneaker(Long basketId, Long sneakerId){
        return basketRepository.existsSneaker(basketId, sneakerId);
    }

    @Transactional
    public void removeSneakerFromBasket(Long basketId, Long sneakerId){
        basketSneakerRepository.deleteByBasketIdAndSneakerId(basketId, sneakerId);
    }

    @Transactional
    public double getTotalPriceForUserBasket(Long userId){
        return basketRepository.getTotalPriceForUser(userId);
    }

    @Transactional
    public void deleteAllSneakerFromBasket(Long basketId){
        basketSneakerRepository.deleteByBasketId(basketId);
    }
}
