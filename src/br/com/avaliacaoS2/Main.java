package br.com.avaliacaoS2;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<Livro> livros = new ArrayList<>();
		Queue<Pessoa> fila = new LinkedList<>(); 
		Scanner input = new Scanner(System.in);
		int opcao;
		int codigo = 0;
		
		do {
			System.out.println("=========== MENU ===========");
	        System.out.println("1. Cadastrar novo livro");
	        System.out.println("2. Listar livros");
	        System.out.println("3. Retirar livro");
	        System.out.println("4. Devolver livro");
	        System.out.println("5. Cadastra lista de espera");
	        System.out.println("6. Lista de espera");
	        System.out.println("0. Sair");
	        System.out.print("Escolha uma opção: ");
	        opcao = input.nextInt();  
	        System.out.println();
		
	        switch (opcao) {
	        	case 1:
	        		System.out.println("======= CADASTRAR LIVRO =======");
	        		codigo++;
	        		input.nextLine();//consome buff
	        		System.out.print("Nome do livro: ");
	        		String nome = input.nextLine();
	        		System.out.print("Nome do autor: ");
	        		String autor = input.nextLine();
	        		
	        		boolean ativo = false;
	        		System.out.print("Quantidade: ");
	        		int qtd = input.nextInt();
	        		if (qtd > 0) {//se qtd CADASTRADA for maior que 0 livro vai estar disponivel
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
	        		
	        		
	        	case 3:// implementar cadastro de fila
	        		System.out.println("======= RETIRADA =======");
	        		System.out.print("Codigo do livro: ");
	        		int codRetirar = input.nextInt();
	        		Livro livroRetirado = buscarLivro(livros, codRetirar);
	        		if (livroRetirado != null){
	        			for (Livro l : livros) {
	        				if (codRetirar == l.getCodigo()) {
	        					l.retirarLivro();
	        					System.out.printf("Livro '%s' retirado!\n", l.getNome());		
	        				}
	        			}
	        		}else {
        				System.out.println("Livro nao encontrado");
        			}
	        		break;
	        		
	        	case 4:
	        		System.out.println("======= DEVOLVER =======");
	        		System.out.print("Codigo do livro: ");
	        		int codDevolver = input.nextInt();
	        		Livro livroDevolvido = buscarLivro(livros, codDevolver);
	        		if (livroDevolvido != null) {
	        			for(Livro l : livros) {
	        				if (codDevolver == l.getCodigo()) {
	        					l.devolverLivro();
	        					System.out.printf("Livro '%s' devolvido!\n", l.getNome());	
	        				}
	        			}
	        		}else {
        				System.out.println("Livro nao encontrado");
        			}
	        		break;
	        		
	        	case 5:
	        		System.out.println("======= CADASTRAR EM FILA =======");
	        		input.nextLine();
	        		System.out.print("Nome: ");
	        		nome = input.nextLine();
	        		System.out.println("Contato: ");
	        		String contato = input.nextLine();
	        		System.out.println("Codigo do livro");
	        		int codLivro = input.nextInt();
	        		Pessoa novaPessoa = new Pessoa(nome, contato, codLivro);
	        		fila.add(novaPessoa);
	        		System.out.println("Cadastro realizado\n");
	        		break;
	        		
	        	case 6:
	        		System.out.println("======= FILA DE ESPERA =======");
	        		if (fila.isEmpty()) {
	        			System.out.println("Não ha fila de espera");
	        		}else {
	        			System.out.print("      NOME      |    CONTATO    | COD LIVRO\n");
	        			for(Pessoa p : fila) {
	        				p.listarPessoa();	
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
