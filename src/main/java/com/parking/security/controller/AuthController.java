package com.parking.security.controller;

import com.parking.security.dto.JwtDto;
import com.parking.security.dto.LoginUsuario;
import com.parking.security.dto.Mensaje;
import com.parking.security.dto.NuevoUsuario;
import com.parking.security.enums.RolNombre;
import com.parking.security.jwt.JwtEntryPoint;
import com.parking.security.jwt.JwtProvider;
import com.parking.security.models.RolModel;
import com.parking.security.models.UsuarioModel;
import com.parking.security.service.RolService;
import com.parking.security.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/create")
   public ResponseEntity<?>nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensaje("campos mal puestos o email invalido "), HttpStatus.BAD_REQUEST);
    if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
        return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
    if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
        return new ResponseEntity(new Mensaje("Ese correo electronico ya existe"), HttpStatus.BAD_REQUEST);
    UsuarioModel usuario = new UsuarioModel(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
            passwordEncoder.encode(nuevoUsuario.getPassword()));
    Set<RolModel> roles= new HashSet<>();
    roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
    if (nuevoUsuario.getRoles().contains("admin"))
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
    usuario.setRoles(roles);
    usuarioService.save(usuario);
    return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos invalidos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
