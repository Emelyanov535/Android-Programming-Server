package com.android.android.Service;

import com.android.android.Model.Basket;
import com.android.android.Model.User;
import com.android.android.Repository.BasketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasketService {
    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Transactional
    public Basket create(User user){
        Basket basket = new Basket(user);
        user.setBasket(basket);
        return basketRepository.save(basket);
    }
}
