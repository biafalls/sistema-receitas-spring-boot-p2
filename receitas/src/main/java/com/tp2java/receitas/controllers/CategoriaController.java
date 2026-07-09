// Beatriz Lima Evangelista e Julia Santos de Souza
package com.tp2java.receitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam; 

import com.tp2java.receitas.entities.Categoria;
import com.tp2java.receitas.repositories.CategoriaRepositorie;

@Controller
public class CategoriaController {
	
    @Autowired
    private CategoriaRepositorie categoriaRepositorie;

    @GetMapping("/categorias/nova")
    public String novaCategoria() {
        return "cadastro_categoria"; 
    }


    @PostMapping("/categorias/salvar")
    public String salvarCategoria(
    		@RequestParam("txtNome") String nomeDigitado, 
            @RequestParam("txtDescricao") String descricaoDigitada) {
        
        Categoria categoria = new Categoria();
        
        categoria.setNome(nomeDigitado);
        categoria.setDescricao(descricaoDigitada);
        
        categoriaRepositorie.save(categoria);
        
        return "redirect:/categorias/listar";
    }
    
    @GetMapping("/categorias/listar")
    public String listarCategorias(Model model) {
        model.addAttribute("listaCategorias", categoriaRepositorie.findAll());
        return "lista_categorias";
    }
}
