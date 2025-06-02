package org.milianz.parcial2.Repositories;

import jakarta.validation.constraints.Null;
import lombok.NonNull;
import org.milianz.parcial2.Domain.Entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface iUserRepository extends iGenericRepository<User, UUID> {
    Optional findByEmail(String email);
}