package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.ProduccionAcademica;
import com.example.seguimientocuerpos.repository.ProduccionAcademicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduccionAcademicaService {

    private final ProduccionAcademicaRepository produccionAcademicaRepository;

    public void save (ProduccionAcademica produccionAcademica){
        produccionAcademicaRepository.save(produccionAcademica);
    }

    public List<ProduccionAcademica> findAll(){
        return produccionAcademicaRepository.findAll();
    }

    public Optional<ProduccionAcademica> findById(String id){
        return produccionAcademicaRepository.findById(id);
    }

    public void deleteById(String id){
        produccionAcademicaRepository.deleteById(id);
    }

    public List<ProduccionAcademica> findByAnio(String anio){
        return produccionAcademicaRepository.findByAnio(anio);
    }

    public List<ProduccionAcademica> findByIntegrantesIdUsuario(String id_usuario){
        return produccionAcademicaRepository.findByIntegrantesIdUsuario(id_usuario);
    }

    public List<ProduccionAcademica> findByTipo(String tipo){
        return produccionAcademicaRepository.findByTipo(tipo);
    }
}
