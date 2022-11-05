package com.parking.security.repository;

import com.parking.security.enums.RolNombre;
import com.parking.security.models.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<RolModel,Integer> {
    Optional<RolModel> findByRolNombre(RolNombre rolNombre);
}
