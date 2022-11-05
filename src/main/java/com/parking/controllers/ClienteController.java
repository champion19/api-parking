package com.parking.controllers;

import com.parking.models.ClientesModel;
import com.parking.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clientesService;

    @GetMapping()
    public List<ClientesModel> obtenerUsuarios(){
        return clientesService.obtenerUsuarios();
    }

    @PostMapping()
    public ClientesModel guardarUsuario(@RequestBody ClientesModel usuario){
        return clientesService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{id}")
    public ClientesModel obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return clientesService.obtenerPorId(id);
    }



    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.clientesService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
