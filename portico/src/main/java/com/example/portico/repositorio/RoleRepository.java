// src/main/java/com/example/portico/repositorio/RoleRepository.java

package com.example.portico.repositorio;

import com.example.portico.entidad.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
