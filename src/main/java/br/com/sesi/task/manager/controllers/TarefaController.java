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

import br.com.sesi.task.manager.models.Tarefa;
import br.com.sesi.task.manager.models.Usuario;
import br.com.sesi.task.manager.repositories.TarefaRepository;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@GetMapping
	public String entrypoint() {
		return "redirect:/tarefa/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("tarefas", tarefaRepository.findAll());
		return "tarefa/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Optional<Tarefa> tarefaOpt = tarefaRepository.findById(id);
		
		if (tarefaOpt.isPresent()) {
			model.addAttribute("tarefa", tarefaOpt.get());
			return "tarefa/form";
		}
		
		return "redirect:/tarefa/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		tarefaRepository.deleteById(id);		
		return "redirect:/tarefa/list";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("tarefa", new Tarefa());
		return "tarefa/form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Tarefa tarefa) {
		tarefaRepository.save(tarefa);
		return "redirect:/tarefa/list";
	}
}
