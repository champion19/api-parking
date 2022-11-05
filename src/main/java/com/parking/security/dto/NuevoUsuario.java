package com.parking.security.dto;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
@NotBlank
@NotNull
@NotEmpty
 private String nombre;
@NotBlank
@NotNull
@NotEmpty
 private String nombreUsuario;
@Email
@Email
@NotEmpty
 private String email;
@NotBlank
@NotEmpty
@Column(nullable = false)
@Size(min = 5, max = 12)
 private String password;
 private Set<String> roles=new HashSet<>();
 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public String getNombreUsuario() {
  return nombreUsuario;
 }

 public void setNombreUsuario(String nombreUsuario) {
  this.nombreUsuario = nombreUsuario;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public Set<String> getRoles() {
  return roles;
 }

 public void setRoles(Set<String> roles) {
  this.roles = roles;
 }
}
