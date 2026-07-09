// Beatriz Lima Evangelista e Julia Santos de Souza
package com.tp2java.receitas.repositories;

import com.tp2java.receitas.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorie extends JpaRepository<Categoria, Integer>{

}
