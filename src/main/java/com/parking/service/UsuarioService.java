package com.parking.service;

import com.parking.models.ClientesModel;
import com.parking.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ClientesModel> obtenerUsuarios(){
        return (List<ClientesModel>) usuarioRepository.findAll();
    }

    public ClientesModel guardarUsuario(ClientesModel usuario){
        return usuarioRepository.save(usuario);
    }

    public ClientesModel obtenerPorId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
