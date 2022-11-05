package com.parking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="vehiculo")

public class VehiculoModel implements Serializable {
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String placa;
    private String tipo;

    @JsonIgnoreProperties({"vehiculos"})
    @ManyToOne(fetch = FetchType.LAZY)
    private ClientesModel cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ClientesModel getUsuario() {
        return cliente;
    }

    public void setUsuario(ClientesModel cliente) {
        this.cliente = cliente;
    }
}
