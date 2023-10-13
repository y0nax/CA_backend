package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ColaboracionCA;
import com.example.seguimientocuerpos.service.ColaboracionCAService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ColaboracionCAController {

    private final ColaboracionCAService colaboracionCAService;

    @PostMapping("/colaboracionCA")
    public void save(@RequestBody ColaboracionCA colaboracionCA){
        colaboracionCAService.save(colaboracionCA);
    }

    @GetMapping("/colaboracionCAs")
    public List<ColaboracionCA> findAll(){
        return colaboracionCAService.findAll();
    }

    @GetMapping("/colaboracionCA/{id}")
    public ColaboracionCA findById(@PathVariable String id){
        return colaboracionCAService.findById(id).get();
    }

    @DeleteMapping("/colaboracionCA/{id}")
    public void deleteById(@PathVariable String id){
        colaboracionCAService.deleteById(id);
    }

    @PutMapping("/colaboracionCA")
    public void update(@RequestBody ColaboracionCA colaboracionCA){
        colaboracionCAService.save(colaboracionCA);
    }
}
