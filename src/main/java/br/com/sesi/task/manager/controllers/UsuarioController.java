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
import br.com.sesi.task.manager.models.Usuario;
import br.com.sesi.task.manager.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public String entrypoint() {
		return "redirect:/usuario/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuario/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Optional<Usuario> tarefaCategoriaOpt = usuarioRepository.findById(id);
		
		if (tarefaCategoriaOpt.isPresent()) {
			model.addAttribute("usuario", tarefaCategoriaOpt.get());
			return "usuario/form";
		}
		
		return "redirect:/usuario/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		usuarioRepository.deleteById(id);		
		return "redirect:/usuario/list";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("categoria", new TarefaCategoria());
		return "usuario/form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Usuario categoria) {
		usuarioRepository.save(categoria);
		return "redirect:/usuario/list";
	}
}
