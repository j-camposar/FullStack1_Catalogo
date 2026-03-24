package com.catalogo.catalogo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.catalogo.Model.Catalogo;
import com.catalogo.catalogo.Service.CatalogoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/producto")
public class CatalogoController {
    @Autowired 
    private CatalogoService catalogoService;
    
    @GetMapping
    public List<Catalogo> buscarTodos(){
        return catalogoService.buscarTodos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Catalogo> buscarPorId(@PathVariable int id) {
        Catalogo catalogoResponse= catalogoService.buscarPorId(id);
        if(catalogoResponse!= null){
            return ResponseEntity.ok(catalogoResponse);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Catalogo> crear(@Valid 
        @RequestBody Catalogo producto){
        return new ResponseEntity<>(catalogoService.save(producto),HttpStatus.CREATED);
    }

    @GetMapping("categoria/{categoria}")
    public ResponseEntity<Catalogo> buscarPorCategoria(@RequestParam String categoria) {
        Catalogo catalogo= catalogoService.buscarCategoria(categoria);
        if(catalogo!=null){
            return ResponseEntity.ok(catalogo);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean eliminado = catalogoService.eliminar(id);
        if(eliminado==true) {
            catalogoService.eliminar(id);
            return ResponseEntity.ok("Eliminado correctamente");
        } else{
            return ResponseEntity.badRequest().build();
        }
    }
}
