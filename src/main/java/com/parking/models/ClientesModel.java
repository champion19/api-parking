package com.parking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;//devuelve la tabla como un Json.
import java.util.List;

@Entity
@Table(name = "clientes")
public class ClientesModel implements Serializable {
    private final static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String numero;

    @JsonIgnoreProperties({"cliente"})
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "cliente")
    private List<VehiculoModel> vehiculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<VehiculoModel> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoModel> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
//post es para craar un usuario
//get ver usuario