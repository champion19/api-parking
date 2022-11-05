package com.parking.repositories;

import com.parking.models.ClientesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<ClientesModel, Long> {


}
