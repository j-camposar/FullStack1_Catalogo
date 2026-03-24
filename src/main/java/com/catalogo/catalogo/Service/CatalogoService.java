package com.catalogo.catalogo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.catalogo.Model.Catalogo;
import com.catalogo.catalogo.Repository.CatalogoRepository;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;

    public Catalogo buscarPorId(int id){
        return catalogoRepository.buscarPorId(id);
    }
    public Catalogo save(Catalogo catalogo){
        return catalogoRepository.save(catalogo);        
    }
    public Boolean eliminar(int id){
        return catalogoRepository.delete(id);
    }
    public List<Catalogo> buscarTodos(){
        return catalogoRepository.buscarTodos();
    }
    public Catalogo buscarCategoria(String categoria){
        return catalogoRepository.buscarCategoria(categoria);
    }
}
