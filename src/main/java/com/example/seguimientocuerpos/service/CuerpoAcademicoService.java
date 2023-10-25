package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.CuerpoAcademico;
import com.example.seguimientocuerpos.repository.CuerpoAcademicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuerpoAcademicoService {

    private final CuerpoAcademicoRepository cuerpoAcademicoRepository;

    public void save(CuerpoAcademico cuerpoAcademico){
        cuerpoAcademicoRepository.save(cuerpoAcademico);
    }

    public List<CuerpoAcademico> findAll(){
        return cuerpoAcademicoRepository.findAll();
    }

    public Optional<CuerpoAcademico> findById(String id){
        return cuerpoAcademicoRepository.findById(id);
    }

    public void deleteById(String id){
        cuerpoAcademicoRepository.deleteById(id);
    }
}
