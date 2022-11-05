package com.parking.repositories;

import com.parking.models.ClientesModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClientesModel, Long> {


}
