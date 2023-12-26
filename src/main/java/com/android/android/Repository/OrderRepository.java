package com.android.android.Repository;

import com.android.android.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.date > :dateFrom AND o.date < :dateTo")
    List<Order> getOrderBetweenDate(@Param("dateFrom") Long dateFrom, @Param("dateTo") Long dateTo);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.date > :dateFrom AND o.date < :dateTo")
    Integer countOrdersBetweenDate(@Param("dateFrom") Long dateFrom, @Param("dateTo") Long dateTo);

    @Query("SELECT AVG(o.total) FROM Order o WHERE o.date > :dateFrom AND o.date < :dateTo")
    Double averageTotalBetweenDate(@Param("dateFrom") Long dateFrom, @Param("dateTo") Long dateTo);

    @Query("SELECT os.sneaker, SUM(os.quantity) as totalQuantity " +
            "FROM OrderSneaker os " +
            "WHERE os._order.date > :dateFrom AND os._order.date < :dateTo " +
            "GROUP BY os.sneaker " +
            "ORDER BY totalQuantity DESC")
    List<Object[]> getMostFrequentSneakersBetweenDate(@Param("dateFrom") Long dateFrom, @Param("dateTo") Long dateTo);
}
