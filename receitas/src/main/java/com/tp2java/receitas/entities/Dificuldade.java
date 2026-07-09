// Beatriz Lima Evangelista e Julia Santos de Souza
package com.tp2java.receitas.entities;

public enum Dificuldade {

	FACIL("Fácil"),
    MEDIO("Médio"),
    DIFICIL("Difícil"); 
	
    private final String exibicao;

    Dificuldade(String exibicao) { 
    	this.exibicao = exibicao;
    }

    public String getExibicao() { return exibicao; }
}