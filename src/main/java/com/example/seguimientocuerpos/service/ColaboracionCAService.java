package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.ColaboracionCA;
import com.example.seguimientocuerpos.repository.ColaboracionCARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboracionCAService {

    private final ColaboracionCARepository colaboracionCARepository;

    public void save(ColaboracionCA colaboracionCA){
        colaboracionCARepository.save(colaboracionCA);
    }

    public List<ColaboracionCA> findAll(){
        return colaboracionCARepository.findAll();
    }

    public Optional<ColaboracionCA> findById(String id){
        return colaboracionCARepository.findById(id);
    }

    public void deleteById(String id){
        colaboracionCARepository.deleteById(id);
    }

    public List<ColaboracionCA> findByAnio(String anio){
        return colaboracionCARepository.findByAnio(anio);
    }

    public List<ColaboracionCA> findByTipo(String tipo){
        return colaboracionCARepository.findByTipo(tipo);
    }

    public List<ColaboracionCA> findByIntegrantesIdCa(String idCa){
        return colaboracionCARepository.findByIntegrantesIdCa(idCa);
    }
}
