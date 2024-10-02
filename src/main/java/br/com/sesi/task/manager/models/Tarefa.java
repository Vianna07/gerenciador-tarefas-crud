package br.com.sesi.task.manager.models;

import java.time.LocalDate;

import br.com.sesi.task.manager.enums.Prioridade;
import br.com.sesi.task.manager.enums.StatusTarefa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusTarefa status;
	private LocalDate dataEntrega;
	private Prioridade prioridade;
	private boolean visivel;
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private TarefaCategoria tarefaCategoria;
	@ManyToOne
	private Usuario usuario;
	
	public Tarefa(String descricao, StatusTarefa statusTarefa, LocalDate dataEntrega, Prioridade prioridade, boolean visivel, TarefaCategoria tarefaCategoria, Usuario usuario) {
		this.descricao = descricao;
		this.status = statusTarefa;
		this.dataEntrega = dataEntrega;
		this.prioridade = prioridade;
		this.visivel = visivel;
		this.tarefaCategoria = tarefaCategoria;
		this.usuario = usuario;
	}
}
