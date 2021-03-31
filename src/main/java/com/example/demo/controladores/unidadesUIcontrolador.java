
package com.example.demo.controladores;


import com.example.demo.modelos.Unidades;
import com.example.demo.servicios.unidadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class unidadesUIcontrolador {
 @Autowired
 private unidadesServicio servicio;
 
 @RequestMapping("/unidades")
 public String doctores(Model model){
     setParametro(model,"listaU", servicio.getTodos());
     return "unidades";
 }
 
 @GetMapping("/crearU")
 public String irCrear(Model model){
     setParametro(model,"crearUnidades", new Unidades());
     return "crearUnidades";
 }
 
 @GetMapping("/actualizarU/{id_unidades}")
 public String irActualizar(@PathVariable("id_unidades") Long id_unidades, Model model){
     setParametro(model,"crearUnidades",servicio.getValor(id_unidades));
     return "crearUnidades";
 }
 
 @PostMapping("/guardarU")
 public String guardar(Unidades unidades, Model model){
     servicio.guardar(unidades);
     return "redirect:/unidades";
 }
 
 @GetMapping("/eliminarU/{id_unidades}")
 public String eliminar(@PathVariable("id_unidades") Long id_unidades, Model model){
     servicio.eliminar(id_unidades);
     return "redirect:/unidades";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }
}
