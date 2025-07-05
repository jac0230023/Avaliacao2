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
	        		System.out.print("Quantidade: ");
	        		int qtd = input.nextInt();
	        		boolean ativo = false;
	        		
	        		Livro novoLivro = new Livro(codigo, nome, autor, qtd, ativo);//chama metodo novoLivro
	        		livros.add(novoLivro);
	        		System.out.println("Livro cadastrado!\n");
	        		
	        		break;
	        		
	        	
	        	case 2:
	        		System.out.println("=========== LISTA ==========");
	        		if (livros.isEmpty()) {
	        			System.out.println("Estoque vazio.");
	        		}else {
	        			System.out.println("CODIGO |    NOME    |    AUTOR   | QTD |   STATUS");
	        			for(Livro l : livros) {
	        				l.listarLivros();//chama metodo listar livros.
	        			}
	        		}	
	        		System.out.println();

	        		break;
	        		
	        		
	        	case 3:
	        		System.out.println("======= RETIRADA =======");
	        		System.out.print("Codigo do livro: ");
	        		int codRetirar = input.nextInt();
	        		Livro livroRetirado = buscarLivro(livros, codRetirar);
	        		if (livroRetirado != null){
	        			for (Livro l : livros) {
	        				if (codRetirar == l.getCodigo()) {
	        					l.listarLivros();
	        					
	        					System.out.println("1. CONFIRMA");
	        					System.out.println("2. VOLTA");
	        					opcao = input.nextInt();
	        					
	        					switch(opcao) {
	        						case 1:
	        							
	        							l.retirarLivro();
	        							
	        			}
	        		}
	        		
	        		
	        			
	        	
	        	
	        	
	        		
	        		
	        
	        
	        
	        		}
	        		}      
	        }
		}while(opcao != 0);
		
		
		
		
		
		
		
		
		
		

		}
	    
	    //metodo buscar livro  
	    private static Livro buscarLivro(List<Livro> livros, int codigo) {
	    	for (Livro l : livros) {
	    		if (l.getCodigo() == codigo) {
	    			return l;
	    		}
	    	}
	    	return null;
	    }

}
