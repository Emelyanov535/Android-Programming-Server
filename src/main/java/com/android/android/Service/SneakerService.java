package com.android.android.Service;

import com.android.android.Model.Sneaker;
import com.android.android.Repository.SneakerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SneakerService {
    private final SneakerRepository sneakerRepository;

    public SneakerService(SneakerRepository sneakerRepository) {
        this.sneakerRepository = sneakerRepository;
    }

    @Transactional
    public Sneaker insert(String brand, String model, String description, Double price, Integer photo) {
        Sneaker sneaker = new Sneaker(brand, model, description, price, photo);
        return sneakerRepository.save(sneaker);
    }
}