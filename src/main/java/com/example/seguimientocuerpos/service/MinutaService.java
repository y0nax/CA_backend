package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.Minuta;
import com.example.seguimientocuerpos.repository.MinutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MinutaService {
    private final MinutaRepository minutaRepository;

    public void save (Minuta minuta){
        minutaRepository.save(minuta);
    }

    public List<Minuta> findAll(){
        return minutaRepository.findAll();
    }

    public Optional<Minuta> findById(String id){
        return minutaRepository.findById(id);
    }

    public void deleteById(String id){
        minutaRepository.deleteById(id);
    }
}
