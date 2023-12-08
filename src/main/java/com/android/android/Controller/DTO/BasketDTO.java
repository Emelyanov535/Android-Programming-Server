package com.android.android.Controller.DTO;

import com.android.android.Model.Basket;
import com.android.android.Model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Информация о корзине")
@Getter
@Setter
@NoArgsConstructor
public class BasketDTO {
    private Long id;
    private Long userId;

    public BasketDTO(Basket basket){
        this.id = basket.getId();
        this.userId = basket.getUser().getId();
    }
}
