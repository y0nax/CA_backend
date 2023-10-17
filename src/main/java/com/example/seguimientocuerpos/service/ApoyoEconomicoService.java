package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.ApoyoEconomico;
import com.example.seguimientocuerpos.repository.ApoyoEconomicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApoyoEconomicoService {

    private final ApoyoEconomicoRepository apoyoEconomicoRepository;

    public void save(ApoyoEconomico apoyoEconomico){
        apoyoEconomicoRepository.save(apoyoEconomico);
    }

    public List<ApoyoEconomico> findAll(){
        return apoyoEconomicoRepository.findAll();
    }

    public Optional<ApoyoEconomico> findById(String id){
        return apoyoEconomicoRepository.findById(id);
    }

    public void deleteById(String id){
        apoyoEconomicoRepository.deleteById(id);
    }
}
