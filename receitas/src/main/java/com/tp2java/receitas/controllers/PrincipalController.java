// Beatriz Lima Evangelista e Julia Santos de Souza
package com.tp2java.receitas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

    @GetMapping("/")
    public String exibirHome() {
        return "index";
    }
}
