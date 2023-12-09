package com.android.android.Repository;

import com.android.android.Model.BasketSneaker;
import com.android.android.Model.BasketSneakerId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketSneakerRepository extends JpaRepository<BasketSneaker, BasketSneakerId> {
    @Transactional
    void deleteByBasketIdAndSneakerId(Long basketId, Long sneakerId);
}
