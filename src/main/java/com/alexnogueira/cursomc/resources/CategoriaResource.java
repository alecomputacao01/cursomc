package com.alexnogueira.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/Categorias")
public class CategoriaResource {
    
    @RequestMapping(method=RequestMethod.GET)
    public String listar(){
      return "REST está funcionando";  
    }

}
