// Beatriz Lima Evangelista e Julia Santos de Souza
package com.tp2java.receitas.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Receita {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String nome, tempoPreparo;
	
	@Column(columnDefinition = "TEXT")
    private String descricao;
	
	@Enumerated(EnumType.STRING)
    private Dificuldade dificuldade;
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
	
	public int getId() { return id; }
	public void setId(Integer id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }

	public String getTempoPreparo() { return tempoPreparo; }
	public void setTempoPreparo(String tempoPreparo) { this.tempoPreparo = tempoPreparo; }

	public Dificuldade getDificuldade() { return dificuldade; }
	public void setDificuldade(Dificuldade dificuldade) { this.dificuldade = dificuldade; }

	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) {this.categoria = categoria;}
}