// src/main/java/com/example/portico/repositorio/UserRepository.java
package com.example.portico.repositorio;

import com.example.portico.entidad.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
    Optional<UserEntity> findByUsername(String username);
}
