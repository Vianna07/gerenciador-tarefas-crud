package br.com.sesi.task.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sesi.task.manager.models.TarefaCategoria;
import br.com.sesi.task.manager.repositories.TarefaCategoriaRepository;

@Configuration
public class CarregaBaseDeDados {
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Bean
	CommandLineRunner executar() {
		return args -> {
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("Estudos");
			
			tarefaCategoriaRepository.save(categoria);
		};
	}
}
