package org.milianz.parcial2.Controllers;

import jakarta.validation.Valid;
import org.milianz.parcial2.Domain.DTOs.FindUserDTO;
import org.milianz.parcial2.Domain.DTOs.RegisterUserDTO;
import org.milianz.parcial2.Domain.Entities.User;
import org.milianz.parcial2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        try {
            userService.createUser(registerUserDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/user/email")
    public ResponseEntity<FindUserDTO> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/user/delete")
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam("email") String email) {
        try {
            userService.deleteUserByEmail(email);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
