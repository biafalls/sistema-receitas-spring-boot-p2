// Beatriz Lima Evangelista e Julia Santos de Souza
package com.tp2java.receitas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.tp2java.receitas.entities.Receita;
import com.tp2java.receitas.entities.Categoria;
import com.tp2java.receitas.entities.Dificuldade;
import com.tp2java.receitas.repositories.ReceitaRepositorie;
import com.tp2java.receitas.repositories.CategoriaRepositorie;

@Controller
public class ReceitaController {

	@Autowired
    private ReceitaRepositorie receitaRepositorie;

    @Autowired
    private CategoriaRepositorie categoriaRepositorie; 

    @GetMapping("/receitas/nova")
    public String novaReceita(Model model) {
        model.addAttribute("todasCategorias", categoriaRepositorie.findAll());
        model.addAttribute("todasDificuldades", Dificuldade.values());
        return "cadastro_receita";
    }

    @PostMapping("/receitas/salvar")
    public String salvarReceita(
            @RequestParam("txtNome") String nome,
            @RequestParam("txtDescricao") String descricao,
            @RequestParam("txtTempoPreparo") String tempoPreparo,
            @RequestParam("selDificuldade") String dificuldadeString, 
            @RequestParam("selCategoria") Integer categoriaId) {

        Receita receita = new Receita();
        receita.setNome(nome);
        receita.setDescricao(descricao);
        receita.setTempoPreparo(tempoPreparo);

        Dificuldade dificuldadeEnum;
        if (dificuldadeString.equals("FACIL")) {
            dificuldadeEnum = Dificuldade.FACIL;
        } else if (dificuldadeString.equals("MEDIO")) {
            dificuldadeEnum = Dificuldade.MEDIO;
        } else {
            dificuldadeEnum = Dificuldade.DIFICIL;
        }
        receita.setDificuldade(dificuldadeEnum);

        Categoria categoriaEscolhida = new Categoria();
        categoriaEscolhida.setId(categoriaId); 
        receita.setCategoria(categoriaEscolhida);
        
        receitaRepositorie.save(receita);

        return "redirect:/receitas/listar";
    }
    
    @GetMapping("/receitas/listar")
    public String listarReceitas(Model model) {
        model.addAttribute("listaReceitas", receitaRepositorie.findAll());
        return "lista_receitas";
    }
	
}
