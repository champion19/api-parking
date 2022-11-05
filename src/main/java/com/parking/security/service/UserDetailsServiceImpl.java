package com.parking.security.service;

import com.parking.security.models.UsuarioModel;
import com.parking.security.models.UsuarioPrincipalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        UsuarioModel usuario= usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipalModel.build(usuario);
    }
}
