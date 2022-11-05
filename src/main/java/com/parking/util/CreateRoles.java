package com.parking.util;

import com.parking.security.enums.RolNombre;
import com.parking.security.models.RolModel;
import com.parking.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        RolModel rolAdmin = new RolModel(RolNombre.ROLE_ADMIN);
        RolModel rolUser = new RolModel(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
    }
}
