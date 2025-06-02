package org.milianz.parcial2.Services;

import org.milianz.parcial2.Domain.DTOs.FindUserDTO;
import org.milianz.parcial2.Domain.DTOs.RegisterUserDTO;
import org.milianz.parcial2.Domain.Entities.User;
import org.milianz.parcial2.Repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private iUserRepository userRepository;

    public void createUser(RegisterUserDTO registerUserDTO) {
        User user = new User();
        user.setUsername(registerUserDTO.getUsername());
        user.setPassword(registerUserDTO.getPassword());
        user.setEmail(registerUserDTO.getEmail());
        userRepository.save(user);
    }

    public FindUserDTO getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found with email: " + email);
        }
        return new FindUserDTO(user.get().getUsername(), user.get().getEmail());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }
}
