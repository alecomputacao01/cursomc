package com.alexnogueira.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexnogueira.cursomc.domain.Categoria;
import com.alexnogueira.cursomc.services.CategoriaService;

import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
  
  private static final Logger logger = LogManager.getLogger(CategoriaResource.class);

  @Autowired
  private CategoriaService service;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){

    logger.info("Recurso /categorias/{id}");  
    Categoria obj = service.buscar(id);
    return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                  .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();          
    }

}