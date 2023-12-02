package com.android.android.Repository;

import com.android.android.Model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
}
