
package com.example.demo.servicios;



import com.example.demo.modelos.Intervenciones;
import com.example.demo.repositorios.intervencionesRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class intervencionesServicio {
    @Autowired
    private intervencionesRepositorio repositorio;
    
    public Intervenciones guardar(Intervenciones entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminar(Long id_inter){
        repositorio.deleteById(id_inter);
    }
    
    public Optional<Intervenciones> getValor(Long id_inter){
        return repositorio.findById(id_inter);
    }
    
    public List<Intervenciones> getTodos(){
        return (List<Intervenciones>)repositorio.findAll();
    }

}