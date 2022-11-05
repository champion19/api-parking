package com.parking.security.dto;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
@NotBlank
@NotNull
 private String nombre;
@NotBlank
@NotNull
 private String nombreUsuario;
@Email
@NotNull
@NotBlank
 private String email;
@NotBlank
@NotNull
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
