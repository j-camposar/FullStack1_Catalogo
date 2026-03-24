package com.catalogo.catalogo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.catalogo.catalogo.Model.Catalogo;

@Repository 
public class CatalogoRepository {
    private List<Catalogo> productos = new ArrayList<>();

    public int idAutoIncremental() {
        return productos.size()+1;
    }
    public Catalogo save(Catalogo catalogo){
        catalogo.setId(idAutoIncremental());
        productos.add(catalogo);
        return catalogo;
    }
    public Boolean delete(int id){
        for(int i=0; i < productos.size();i++ ){
            if(productos.get(i).getId()== id){
                productos.remove(i);
                return true;
            }
        }
        return false;
    }
    public List<Catalogo> buscarTodos(){
        return productos;
    }
    public Catalogo buscarPorId(int id){
        for (Catalogo catalogo : productos) {
            if(catalogo.getId()==id){
                return catalogo;
            }
        }
        return null;
    }
    public Catalogo buscarCategoria(String categoria){
         for (Catalogo catalogo : productos) {
            if(catalogo.getCategoria()== categoria){
                return catalogo;
            }
        }
        return null;
    }
    
}
