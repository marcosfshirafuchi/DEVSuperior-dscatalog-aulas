package com.devsuperior.dscatalog.resources;

import com.devsuperior.dscatalog.entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Definindo a classe de Controller
@RestController
//Definindo a rota classe controller no Postman
@RequestMapping(value = "/categories")
public class CategoryResource {

    @GetMapping
    //O ResponseEntity vai encapsular uma resposta HTTP
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = new ArrayList<>();
        list.add(new Category(1L,"Books"));
        list.add(new Category(2L,"Eletronics"));
        return ResponseEntity.ok().body(list);
    }
}
