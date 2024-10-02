package br.com.sesi.task.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sesi.task.manager.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

}
