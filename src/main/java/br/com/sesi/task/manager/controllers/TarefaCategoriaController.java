package br.com.sesi.task.manager.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sesi.task.manager.models.TarefaCategoria;
import br.com.sesi.task.manager.repositories.TarefaCategoriaRepository;

@Controller
@RequestMapping("/tarefa-categoria")
public class TarefaCategoriaController {
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@GetMapping
	public String entrypoint() {
		return "redirect:/tarefa-categoria/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("categorias", tarefaCategoriaRepository.findAll());
		return "tarefa-categoria/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Optional<TarefaCategoria> tarefaCategoriaOpt = tarefaCategoriaRepository.findById(id);
		
		if (tarefaCategoriaOpt.isPresent()) {
			model.addAttribute("categoria", tarefaCategoriaOpt.get());
			return "tarefa-categoria/form";
		}
		
		return "redirect:/tarefa-categoria/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		tarefaCategoriaRepository.deleteById(id);		
		return "redirect:/tarefa-categoria/list";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("categoria", new TarefaCategoria());
		return "tarefa-categoria/form";
	}
	
	@PostMapping("/save")
	public String save(TarefaCategoria categoria) {
		tarefaCategoriaRepository.save(categoria);
		return "redirect:/tarefa-categoria/list";
	}
}
