package com.parking.security.service;

import com.parking.security.enums.RolNombre;
import com.parking.security.models.RolModel;
import com.parking.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    public Optional<RolModel> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(RolModel rolModel){
        rolRepository.save(rolModel);
    }
}

