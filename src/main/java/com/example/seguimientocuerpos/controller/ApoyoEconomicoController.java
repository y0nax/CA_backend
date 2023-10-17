package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ApoyoEconomico;
import com.example.seguimientocuerpos.service.ApoyoEconomicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApoyoEconomicoController {

    private final ApoyoEconomicoService apoyoEconomicoService;

    @PostMapping("/apoyoEconomico")
    public void save(@RequestBody ApoyoEconomico apoyoEconomico){
        apoyoEconomicoService.save(apoyoEconomico);
    }

    @GetMapping("/apoyoEconomicos")
    public List<ApoyoEconomico> findAll(){
        return apoyoEconomicoService.findAll();
    }

    @GetMapping("/apoyoEconomico/{id}")
    public ApoyoEconomico findById(@PathVariable String id){
        return apoyoEconomicoService.findById(id).get();
    }

    @DeleteMapping("/apoyoEconomico/{id}")
    public void deleteById(@PathVariable String id){
        apoyoEconomicoService.deleteById(id);
    }

    @PutMapping("/apoyoEconomico")
    public void update(@RequestBody ApoyoEconomico apoyoEconomico){
        apoyoEconomicoService.save(apoyoEconomico);
    }
}
