package br.com.avaliacaoS2;

public class Livro {
	private int codigo;
	private String nome;
	private String autor;
	private int qtd;
	private boolean ativo;
	
	public Livro(int codigo, String nome, String autor,int qtd, boolean ativo) {
			this.codigo = codigo;
			this.nome = nome;
			this.autor = autor;
			this.qtd = qtd;
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
	public int getQtd() {
		return qtd;
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
	public void setQtd() {
		this.qtd = qtd;
	}
	public void setAtivo() {
		this.ativo = ativo;
	}

	public void listarLivros() {
		if (this.ativo == false) {
			System.out.printf("%-6d | %-10s | %-10s | %-3d | Inativo \n", this.codigo, this.nome, this.autor, this.qtd);
		} else {
			System.out.printf("%-6d | %-10s | %-10s | %-3d | Ativo \n", this.codigo, this.nome, this.autor, this.qtd);
		}
		
	}
	
	public void retirarLivro() {
		if (this.qtd > 0) {
			this.qtd = this.qtd - 1;	
		}
	}
	
}
