package models;

/**
 * Uma classe que representa um tema estudado em uma disciplina
 * @author Júlio Neves
 *
 */
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
	
	private String nome;
	
	public String getNome(){
		return nome;
	}
	
}
