package com.android.android.Service;

import com.android.android.Model.Sneaker;
import com.android.android.Repository.SneakerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Transactional
    public Sneaker update(Long id, String brand, String model, String description, Double price, Integer photo){
        final Sneaker sneaker = findSneaker(id);
        sneaker.setBrand(brand);
        sneaker.setModel(model);
        sneaker.setDescription(description);
        sneaker.setPrice(price);
        sneaker.setPhoto(photo);
        return sneakerRepository.save(sneaker);
    }

    @Transactional
    public Sneaker delete(Long id){
        final Sneaker curSneaker = findSneaker(id);
        sneakerRepository.delete(curSneaker);
        return curSneaker;
    }

    @Transactional
    public Sneaker findSneaker(Long id){
        return sneakerRepository.getReferenceById(id);
    }

    @Transactional
    public Page<Sneaker> getAllSneakerPaged(int page, int size){
        return sneakerRepository.findAll(PageRequest.of(page - 1, size));
    }
}