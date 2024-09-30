package br.com.sesi.task.manager.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.sesi.task.manager.models.TarefaCategoria;
import br.com.sesi.task.manager.repositories.TarefaCategoriaRepository;

@Controller
public class TarefaCategoriaController {
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@GetMapping("listarCategoria")
	public String listarCategoria(Model model) {
		model.addAttribute("categorias", tarefaCategoriaRepository.findAll());
		return "listarTarefaCategoria";
	}
	
	@GetMapping("/editarCategoria/{id}")
	public String editarCategoria(@PathVariable("id") int id, Model modelo) {
		Optional<TarefaCategoria> tarefaCategoriaOpt = tarefaCategoriaRepository.findById(id);
		
		if (tarefaCategoriaOpt.isPresent()) {
			modelo.addAttribute("categoria", tarefaCategoriaOpt.get());
		} else {
			return "redirect:listarTarefaCategoria";
		}
		
		return "formularioTarefaCategoria";
	}
	
	@GetMapping("formularioCategoria")
	public String mostrarFormuario(Model model) {
		return "";
	}
}
