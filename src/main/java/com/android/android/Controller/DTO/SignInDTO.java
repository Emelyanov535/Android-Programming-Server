package com.android.android.Controller.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInDTO {
    private String email;
    private String password;

    public SignInDTO(String email, String password){
        this.email = email;
        this.password = password;
    }
}
