// Beatriz Lima Evangelista e Julia Santos de Souza
package com.tp2java.receitas.repositories;

import com.tp2java.receitas.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

public interface ReceitaRepositorie extends JpaRepository<Receita, Integer>{

}
