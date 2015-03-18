package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

/**
 * Uma classe que representa um tema estudado em uma disciplina
 * @author Júlio Neves
 *
 */
@Entity
public class Tema {
	
	public enum Dificuldade{
		MUITO_FACIL(-2), FACIL(-1), MEDIO(0), DIFICIL(1), MUITO_DIFICIL(2);
		
		private int valorNumerico;
		private Dificuldade(int valor){
			valorNumerico = valor;
		}
		
		public int getValorNumerico(){
			return valorNumerico;
		}
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@ElementCollection
	private Map<Aluno, Dificuldade> avaliacoes;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Dica> dicas;
	
	
	public Tema(String nome){
		dicas = new ArrayList<Dica>();
		avaliacoes = new HashMap<Aluno, Dificuldade>();
		this.nome = nome;
	}
	
	public Tema(){
		this("");
	}

	public String getNome(){
		return nome;
	}
	
	public Long getId(){
		return id;
	}
	
}
