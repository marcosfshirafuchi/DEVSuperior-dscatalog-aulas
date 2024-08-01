package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    //Injeta dependencia
    @Autowired
    private CategoryRepository repository;

    //Garante a integridade das transações no banco de dados
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();

        //Cada x(elemento) do list vai ser transformado elemento da listDTO
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

        /*//Outra forma de converter list para listDTO
        List<CategoryDTO> listDTO = new ArrayList<>();
        //Cada elemento(cat) da list é colocado no listDTO
        for (Category cat : list){
            listDTO.add(new CategoryDTO(cat));
        }
        return listDTO;*/
    }

    //Garante a integridade das transações no banco de dados
    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(()-> new EntityNotFoundException("Entity not found"));
        return new CategoryDTO(entity);
    }
}
