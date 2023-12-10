package com.android.android.Repository;

import com.android.android.Model.Basket;
import com.android.android.Model.BasketSneaker;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE BasketSneaker bs SET bs.quantity = bs.quantity + 1 WHERE bs.basket.id = :basketId AND bs.sneaker.id = :sneakerId")
    void incrementSneakerQuantity(@Param("basketId") Long basketId, @Param("sneakerId") Long sneakerId);

    @Modifying
    @Transactional
    @Query("UPDATE BasketSneaker bs SET bs.quantity = bs.quantity - 1 WHERE bs.basket.id = :basketId AND bs.sneaker.id = :sneakerId")
    void decrementSneakerQuantity(@Param("basketId") Long basketId, @Param("sneakerId") Long sneakerId);

    @Transactional
    @Query("SELECT COUNT(bs) > 0 FROM BasketSneaker bs WHERE bs.basket.id = :basketId AND bs.sneaker.id = :sneakerId")
    boolean existsSneaker(@Param("basketId") Long basketId, @Param("sneakerId") Long sneakerId);

    @Query("SELECT COALESCE(SUM(bs.sneaker.price * bs.quantity), 0) FROM BasketSneaker bs WHERE bs.basket.id = :userId")
    double getTotalPriceForUser(@Param("userId") Long userId);
}
