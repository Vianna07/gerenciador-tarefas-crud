package br.com.sesi.task.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sesi.task.manager.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
