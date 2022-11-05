package com.parking.service;

import com.parking.models.ClientesModel;
import com.parking.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClientesModel> obtenerUsuarios(){
        return (List<ClientesModel>) clienteRepository.findAll();
    }

    public ClientesModel guardarUsuario(ClientesModel usuario){
        return clienteRepository.save(usuario);
    }

    public ClientesModel obtenerPorId(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public boolean eliminarUsuario(Long id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
