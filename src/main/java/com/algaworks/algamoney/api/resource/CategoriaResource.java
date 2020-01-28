package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public void criar(@Valid @RequestBody Categoria categoria , HttpServletResponse response){
         Categoria categoriaSalva = categoriaRepository.save(categoria);
    }

    @RequestMapping(value = "/{codigo}", method =  RequestMethod.GET)
    public Categoria buscarPeloCodigo(@PathVariable Long codigo) {
        return categoriaRepository.getOne(codigo);
    }

}
