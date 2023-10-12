package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.Minuta;
import com.example.seguimientocuerpos.service.MinutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MinutaController {

    private final MinutaService minutaService;

    @PostMapping("/minuta")
    public void save(@RequestBody Minuta minuta){
        minutaService.save(minuta);
    }

    @GetMapping("/minutas")
    public List<Minuta> findAll(){
        return minutaService.findAll();
    }

    @GetMapping("/minuta/{id}")
    public Minuta findById(@PathVariable String id){
        return minutaService.findById(id).get();
    }

    @DeleteMapping("/minuta/{id}")
    public void deleteById (@PathVariable String id){
        minutaService.deleteById(id);
    }
}
