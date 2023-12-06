package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.OrderDTO;
import com.android.android.Controller.DTO.SignInDTO;
import com.android.android.Controller.DTO.UserDTO;
import com.android.android.Model.Order;
import com.android.android.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signin")
    public UserDTO signIn(@RequestBody SignInDTO signInDTO){
        return new UserDTO(userService.signIn(signInDTO.getEmail(), signInDTO.getPassword()));
    }

    @PostMapping("/signup")
    public UserDTO signUp(@RequestBody UserDTO userDTO){
        return new UserDTO(userService.signUp(userDTO));
    }

    @GetMapping("/getorders/{id}")
    public List<OrderDTO> getUserOrders(@PathVariable("id") Long id){
        return userService.getUserOrders(id).stream()
                .map(OrderDTO::new)
                .toList();
    }
}
