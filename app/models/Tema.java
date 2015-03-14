package models;

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
	
	public Tema(){
	}
	
	public Tema(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
}
