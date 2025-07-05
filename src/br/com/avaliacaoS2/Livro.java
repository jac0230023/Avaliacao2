package br.com.avaliacaoS2;

public class Livro {
	private int codigo;
	private String nome;
	private String categoria;
	private String autor;
	private boolean ativo;
	
	public Livro(int codigo, String nome, String autor, boolean ativo) {
			this.codigo = codigo;
			this.nome = nome;
			this.categoria = categoria;
			this.autor = autor;
			this.ativo = ativo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	public String getNome() {
		return this.nome;
	}
	public String getAutor() {
		return this.autor;		
	}
	public boolean getAtivo() {
		return ativo;
	}
	public void setCodigo() {
		this.codigo = codigo;
	}
	public void setNome() {
		this.nome = nome;
	}
	public void setAutor() {
		this.autor = autor;
	}
	public void setAtivo() {
		this.ativo = ativo;
	}

	public void listarLivros() {
		if (this.ativo == false) {
			System.out.printf("%-6d | %-10s | %-10s | Inativo \n", this.codigo, this.nome, this.autor);
		} else {
			System.out.printf("%-6d | %-10s | %-10s | Ativo \n", this.codigo, this.nome, this.autor);
		}
		
	}
}
