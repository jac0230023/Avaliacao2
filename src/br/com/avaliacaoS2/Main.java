package br.com.avaliacaoS2;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Livro> livros = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("=========== MENU ===========");
	        System.out.println("1. Cadastrar novo livro");
	        System.out.println("2. Listar livros");
	        System.out.println("3. Retirar livro");
	        System.out.println("4. Cadastrar lista de espera");
	        System.out.println("5. Listar espera");
	        System.out.println("0. Sair");
	        System.out.print("Escolha uma opção: ");
	        opcao = input.nextInt();  
	        System.out.println();
		
	        switch (opcao) {
	        	case 1:
	        		System.out.print("Codigo: ");
	        		int codigo = input.nextInt();
	        		input.nextLine();//consome buff
	        		System.out.print("Nome do livro: ");
	        		String nome = input.nextLine();
	        		System.out.print("Nome do autor: ");
	        		String autor = input.nextLine();
	        		boolean ativo = false;
	        		
	        		Livro novoLivro = new Livro(codigo, nome, autor, ativo);
	        		livros.add(novoLivro);
	        		System.out.println("Livro cadastrado!\n");
	        		
	        		break;
	        		
	        	
	        	case 2:
	        		if (livros.isEmpty()) {
	        			System.out.println("Estoque vazio.");
	        		}else {
	        			System.out.println("CODIGO |    NOME    |    AUTOR   |   STATUS");
	        			for(Livro l : livros) {
	        				l.listarLivros();//chama metodo listar livros.
	        		}
	        		System.out.println();

	        	}
	        		
	        		
	        
	        
	        
	        }
	        
	        
		}while(opcao != 0);
		
		
	}

}
