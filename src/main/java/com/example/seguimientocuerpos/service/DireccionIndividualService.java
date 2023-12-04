package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.DireccionIndividual;
import com.example.seguimientocuerpos.repository.DireccionIndividualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DireccionIndividualService {

    private final DireccionIndividualRepository direccionIndividualRepository;

    public void save(DireccionIndividual direccionIndividual){
        direccionIndividualRepository.save(direccionIndividual);
    }

    public List<DireccionIndividual> findAll(){
        return direccionIndividualRepository.findAll();
    }

    public Optional<DireccionIndividual> findById(String id){
        return direccionIndividualRepository.findById(id);
    }

    public void deleteById(String id){
        direccionIndividualRepository.deleteById(id);
    }

    public List<DireccionIndividual> findByAnio(String anio){
        return direccionIndividualRepository.findByAnio(anio);
    }

    public List<DireccionIndividual> findByIdCa(String idCa){
        return direccionIndividualRepository.findByIdCa(idCa);
    }

    public List<DireccionIndividual> findByNivel(String nivel){
        return direccionIndividualRepository.findByNivel(nivel);
    }
}
