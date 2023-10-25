package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.Usuario;
import com.example.seguimientocuerpos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(String id){
        return usuarioRepository.findById(id);
    }

    public void deleteById(String id){
        usuarioRepository.deleteById(id);
    }
}
