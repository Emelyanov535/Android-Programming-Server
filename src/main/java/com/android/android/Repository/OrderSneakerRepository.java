package com.android.android.Repository;

import com.android.android.Model.BasketSneaker;
import com.android.android.Model.BasketSneakerId;
import com.android.android.Model.OrderSneaker;
import com.android.android.Model.OrderSneakerId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSneakerRepository extends JpaRepository<OrderSneaker, OrderSneakerId> {
}
