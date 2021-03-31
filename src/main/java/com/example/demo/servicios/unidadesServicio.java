
package com.example.demo.servicios;



import com.example.demo.modelos.Unidades;
import com.example.demo.repositorios.unidadesRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class unidadesServicio {
    @Autowired
    private unidadesRepositorio repositorio;
    
    public Unidades guardar(Unidades entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminar(Long id_doctor){
        repositorio.deleteById(id_doctor);
    }
    
    public Optional<Unidades> getValor(Long id_doctor){
        return repositorio.findById(id_doctor);
    }
    
    public List<Unidades> getTodos(){
        return (List<Unidades>)repositorio.findAll();
    }

}