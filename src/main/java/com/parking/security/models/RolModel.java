package com.parking.security.models;

import com.parking.security.enums.RolNombre;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "rol")
public class RolModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 @NotNull
 @Enumerated(EnumType.STRING)
 private RolNombre rolNombre;

    public RolModel() {

    }

    public RolModel(RolNombre rolNombre) {

        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
