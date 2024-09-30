package br.com.sesi.task.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sesi.task.manager.models.TarefaCategoria;

@Repository
public interface TarefaCategoriaRepository extends JpaRepository<TarefaCategoria, Integer> {

}
