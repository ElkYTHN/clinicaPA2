
package com.example.demo.repositorios;



import com.example.demo.modelos.Intervenciones;
import org.springframework.data.repository.CrudRepository;


public interface intervencionesRepositorio extends CrudRepository<Intervenciones, Long> {
    
}