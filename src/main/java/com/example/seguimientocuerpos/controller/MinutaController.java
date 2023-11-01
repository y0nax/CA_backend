package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.Minuta;
import com.example.seguimientocuerpos.service.MinutaService;
import com.example.seguimientocuerpos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MinutaController {

    private final MinutaService minutaService;
    private final UsuarioService usuarioService;

    @PostMapping("/minuta")
    public void save(@RequestBody Minuta minuta){
        minutaService.save(minuta);
    }

    @GetMapping("/minutas")
    public List<Minuta> findAll(){
        return minutaService.findAll();
    }

    @GetMapping("/minuta/{id}/{id_usuario}")
    public ResponseEntity<Object> findById(@PathVariable String id,@PathVariable String id_usuario){
        if(usuarioService.findById(id_usuario).get().getIdCa().equals(minutaService.findById(id).get().getIdCa())){
            return new ResponseEntity<>(minutaService.findById(id).get(),HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/minutaTipo/{tipo}/{id_usuario}")
    public ResponseEntity<Object> findByTipo(@PathVariable String tipo,@PathVariable String id_usuario){
        List<Minuta> filtro = new ArrayList<>();
        for (Minuta m: minutaService.findByTipo(tipo)){
            if(usuarioService.findById(id_usuario).get().getIdCa().equals(m.getIdCa()))
                filtro.add(m);
        }
        if(filtro.size()>0)
            return new ResponseEntity<>(filtro,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/minuta/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById (@PathVariable String id, @PathVariable String id_usuario) {
        if (usuarioService.findById(id_usuario).get().getIdCa().equals(minutaService.findById(id).get().getIdCa())) {
            if (usuarioService.findById(id_usuario).get().getRol().equals("LIDER")) {
                minutaService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
