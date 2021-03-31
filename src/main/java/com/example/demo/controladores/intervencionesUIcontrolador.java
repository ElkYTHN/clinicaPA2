
package com.example.demo.controladores;


import com.example.demo.modelos.Intervenciones;
import com.example.demo.servicios.intervencionesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class intervencionesUIcontrolador {
 @Autowired
 private intervencionesServicio servicio;
 
 @RequestMapping("/intervenciones")
 public String intervenciones(Model model){
     setParametro(model,"listaI", servicio.getTodos());
     return "intervenciones";
 }
 
 @GetMapping("/crearI")
 public String irCrear(Model model){
     setParametro(model,"crearIntervenciones", new Intervenciones());
     return "crearIntervenciones";
 }
 
 @GetMapping("/actualizarI/{id_inter}")
 public String irActualizar(@PathVariable("id_inter") Long id_inter, Model model){
     setParametro(model,"crearIntervenciones",servicio.getValor(id_inter));
     return "crearIntervenciones";
 }
 
 @PostMapping("/guardarI")
 public String guardar(Intervenciones intervenciones, Model model){
     servicio.guardar(intervenciones);
     return "redirect:/intervenciones";
 }
 
 @GetMapping("/eliminarI/{id_inter}")
 public String eliminar(@PathVariable("id_inter") Long id_inter, Model model){
     servicio.eliminar(id_inter);
     return "redirect:/intervenciones";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }
}
