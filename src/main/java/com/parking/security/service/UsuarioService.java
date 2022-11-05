package com.parking.security.service;


import com.parking.security.models.UsuarioModel;
import com.parking.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
   public boolean existsByNombreUsuario(String  nombreUsuario){
        return usuarioRepository. existsByNombreUsuario(nombreUsuario);
    }
    public boolean existsByEmail(String email){
        return usuarioRepository. existsByemail(email);
    }

    public void save(UsuarioModel usuarioModel) {
        usuarioRepository.save(usuarioModel);
    }
}
