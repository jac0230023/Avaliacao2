package br.com.avaliacaoS2;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Livro> livros = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int opcao;
		int codigo = 0;
		
		do {
			System.out.println("=========== MENU ===========");
	        System.out.println("1. Cadastrar novo livro");
	        System.out.println("2. Listar livros");
	        System.out.println("3. Retirar livro");
	        System.out.println("4. Devolver livro");
	        System.out.println("5. Lista de espera");
	        System.out.println("0. Sair");
	        System.out.print("Escolha uma opção: ");
	        opcao = input.nextInt();  
	        System.out.println();
		
	        switch (opcao) {
	        	case 1:
	        		System.out.println("======= DEVOLVER =======");
	        		codigo++;
	        		input.nextLine();//consome buff
	        		System.out.print("Nome do livro: ");
	        		String nome = input.nextLine();
	        		System.out.print("Nome do autor: ");
	        		String autor = input.nextLine();
	        		
	        		boolean ativo = false;
	        		System.out.print("Quantidade: ");
	        		int qtd = input.nextInt();
	        		if (qtd > 0) {//se qtd for maior que 0 livro vai estar disponivel
	        			ativo = true;
	        		}
	        		
	        		
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
	        		
	        		
	        	case 3:// implementar funca se o livo estiver 0 direciona para cadastro de esperar
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
	        							System.out.println("Livro retirado!\n");
	        						case 2:
	        							System.out.print("Em breve");
	        					}		
	        				}
	        			}
	        		}
	        		
	        	case 4:
	        		System.out.println("======= DEVOLVER =======");
	        		System.out.print("Codigo do livro: ");
	        		int codDevolver = input.nextInt();
	        		Livro livroDevolvido = buscarLivro(livros, codDevolver);
	        		if (livroDevolvido != null) {
	        			for(Livro l : livros) {
	        				if (codDevolver == l.getCodigo()) {
	        					l.listarLivros();
	        					
	        					System.out.println("1. CONFIRMA");
	        					System.out.println("2. VOLTA");
	        					opcao = input.nextInt();
	        					
	        					switch(opcao) {
	        						case 1:
	        							l.devolverLivro();
	        							System.out.println("Livro devolvido!\n");
	        						case 2:
	        							System.out.print("Em breve");
	        					}		
	        				}
	        			}
	        		}
	        		
	        		//cadastra espera por livro e verificar limpeza de sistema
	        		
	        		
	        			
	        	
	        	
	        	
	        		
	        		
	        
	        
	        
	        		
       		}      
	        
		
		
		}while(opcao != 0);
		input.close();
		
		
		
		
		
		
		
		
		

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
