package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.ProyectosColectivos;
import com.example.seguimientocuerpos.repository.ProyectosColectivosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProyectosColectivosService {

    private final ProyectosColectivosRepository proyectosColectivosRepository;

    public void save(ProyectosColectivos proyectosColectivos){
        proyectosColectivosRepository.save(proyectosColectivos);
    }

    public List<ProyectosColectivos> findAll(){
        return proyectosColectivosRepository.findAll();
    }

    public Optional<ProyectosColectivos> findById(String id){
        return proyectosColectivosRepository.findById(id);
    }

    public void deleteById(String id){
        proyectosColectivosRepository.deleteById(id);
    }
}
