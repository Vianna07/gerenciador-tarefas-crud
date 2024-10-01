package br.com.sesi.task.manager.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sesi.task.manager.models.TarefaCategoria;
import br.com.sesi.task.manager.models.Usuario;
import br.com.sesi.task.manager.repositories.TarefaCategoriaRepository;
import br.com.sesi.task.manager.repositories.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Bean
	public CommandLineRunner executar() {
		return args -> {
			List<TarefaCategoria> categorias = new ArrayList<TarefaCategoria>(
					Arrays.asList(
							new TarefaCategoria("Estudar"),
							new TarefaCategoria("Dormir"),
							new TarefaCategoria("Comer"),
							new TarefaCategoria("Jogar"),
							new TarefaCategoria("Assistir")
					)
			);
			
			List<Usuario> usuarios = new ArrayList<Usuario>(
					Arrays.asList(
							new Usuario("Fernando", "Madu❤"),
							new Usuario("Madu", "Fernando❤"),
							new Usuario("Vianna", "12345678"),
							new Usuario("Maycon", "87654321"),
							new Usuario("Joaquim", "Curitiba")
					)
			);
			
			tarefaCategoriaRepository.saveAll(categorias);
			usuarioRepository.saveAll(usuarios);
		};
	}
}
