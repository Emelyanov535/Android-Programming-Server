package com.android.android.Controller.DTO;

import com.android.android.Model.Sneaker;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Информация о кроссовке")
@Getter
@Setter
@NoArgsConstructor
public class SneakerDTO {
    private Long id;
    private String brand;
    private String model;
    private String description;
    private Double price;
    private Integer photo;

    public SneakerDTO(Sneaker sneaker) {
        this.id = sneaker.getId();
        this.model = sneaker.getModel();
        this.brand = sneaker.getBrand();
        this.description = sneaker.getDescription();
        this.price = sneaker.getPrice();
        this.photo = sneaker.getPhoto();
    }
}