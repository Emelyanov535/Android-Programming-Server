package com.android.android.Repository;

import com.android.android.Model.Sneaker;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
    @Query("SELECT s FROM Sneaker s WHERE LOWER(:searchString) LIKE CONCAT('%', LOWER(s.brand), '%') OR LOWER(:searchString) LIKE CONCAT('%', LOWER(s.model), '%')")
    List<Sneaker> findSneakersByBrandOrModel(@Param("searchString") String searchString, PageRequest pageRequest);
}
