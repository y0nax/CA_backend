package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.Usuario;
import com.example.seguimientocuerpos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/usuario")
    public void save(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario findById(@PathVariable String id){
        return usuarioService.findById(id).get();
    }

    @DeleteMapping("/usuario/{id}")
    public void deleteById(@PathVariable String id){
        usuarioService.deleteById(id);
    }

    @PutMapping("/usuario")
    public void update(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
    }
}
