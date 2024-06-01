package br.com.brandao.help_pets.controller.document;

import br.com.brandao.help_pets.dto.UserDTO;
import br.com.brandao.help_pets.module.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

public interface IUserController {

    @GetMapping
    Page<UserDTO> getAllUsers(@RequestParam(required = false) Integer page,
                              @RequestParam(required = false) Integer size);

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable UUID id);

    @PostMapping
    ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO);

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable UUID id, @Valid @RequestBody UserDTO userDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable UUID id);
}
