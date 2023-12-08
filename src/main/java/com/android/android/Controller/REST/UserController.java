package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.OrderDTO;
import com.android.android.Controller.DTO.SignInDTO;
import com.android.android.Controller.DTO.UserDTO;
import com.android.android.Model.User;
import com.android.android.Service.BasketService;
import com.android.android.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    private final BasketService basketService;

    public UserController(UserService userService, BasketService basketService) {
        this.userService = userService;
        this.basketService = basketService;
    }

    @PostMapping("/signin")
    public UserDTO signIn(@RequestBody SignInDTO signInDTO){
        return new UserDTO(userService.signIn(signInDTO.getEmail(), signInDTO.getPassword()));
    }

    @PostMapping("/signup")
    public UserDTO signUp(@RequestBody UserDTO userDTO){
        User user = userService.signUp(userDTO);
        basketService.create(user);
        return new UserDTO(user);
    }

    @GetMapping("/getorders/{id}")
    public List<OrderDTO> getUserOrders(@PathVariable("id") Long id){
        return userService.getUserOrders(id).stream()
                .map(OrderDTO::new)
                .toList();
    }
}
