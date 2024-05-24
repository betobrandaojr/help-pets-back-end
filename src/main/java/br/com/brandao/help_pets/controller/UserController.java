package br.com.brandao.help_pets.controller;

import br.com.brandao.help_pets.entity.User;
import br.com.brandao.help_pets.entity.dto.UserDto;
import br.com.brandao.help_pets.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto searchUser(@RequestBody UserDto userDto){
        User user = userDto.transforInEntity();
        return userService.findUser(user);
    }
}
