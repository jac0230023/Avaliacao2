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
					exibirMenu();
	        opcao = input.nextInt();  
	        System.out.println();
		
	        switch (opcao) {
	        	case 1:
	        		exibirTitulo("CADASTRAR LIVRO");
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
	        		System.out.printf("Livro '%s' cadastrado!\n", nome);
	        		input.nextLine();
	        		System.out.print("\nPressione ENTER para continuar!");
	        		String skip = input.nextLine();
	        		break;
	        		
	        		
	        	
	        	case 2:
	        		exibirTitulo("ACERVO");
	        		if (livros.isEmpty()) {
	        			System.out.println("Estoque vazio.");
	        		}else {
	        			System.out.println("CODIGO |    NOME    |    AUTOR   | QTD |   STATUS");
	        			for(Livro l : livros) {
	        				l.listarLivros();//chama metodo listar livros.
	        			}
	        		}	
	        		System.out.println();
	        		input.nextLine();
	        		System.out.print("\nPressione ENTER para continuar!");
	        		skip = input.nextLine();
	        		break;
	        		
	        		
	        	case 3:// implementar direcionamento para cadastro de fila
							exibirTitulo("RETIRADA");
	        		System.out.print("Codigo do livro: ");
	        		int codRetirar = input.nextInt();
	        		Livro livroRetirado = buscarLivro(livros, codRetirar);
	        		if (livroRetirado != null){	
	        			if(livroRetirado.retirarLivro()) {
	        				System.out.printf("Livro '%s' retirado!\n", livroRetirado.getNome());
	        			}else {
	        				System.out.println("Não há disponibilidade.");
	        				System.out.println("Entrar na fila de espera?");
	        				System.out.println("1. SIM");
	        				System.out.println("2. NÃO");
	        				int opcao2 = input.nextInt();
	        				switch (opcao2) {
	        				case 1: 
	        					System.out.println("======= CADASTRAR EM FILA =======");
	        	        		input.nextLine();
	        	        		System.out.print("Nome: ");
	        	        		nome = input.nextLine();
	        	        		System.out.print("Contato: ");
	        	        		String contato = input.nextLine();
	        	        		Pessoa novaPessoa = new Pessoa(nome, contato, livroRetirado.getCodigo());
	        	        		fila.add(novaPessoa);
	        	        		System.out.println("Cadastro realizado!");
	        	        		System.out.print("\nPressione ENTER para continuar!");
	        	        		skip = input.nextLine();
	        	        		break;
	        				case 2:
	        					System.out.println("Sem problema!\n");
	        	        		System.out.print("\nPressione ENTER para continuar!");
	        	        		break;
	        				default:
	        					System.out.println("Opção invalida.");
	        				break;
	        				}
	        			}
	        					
	        		}else {
        				System.out.println("Livro nao encontrado");
        			}
	        		input.nextLine();
	        		System.out.print("\nPressione ENTER para continuar!");
	        		skip = input.nextLine();
	        		break;
	        		
	        		
	        	case 4:
							exibirTitulo("DEVOLUÇÃO");
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
	        		input.nextLine();
	        		System.out.print("\nPressione ENTER para continuar!");
	        		skip = input.nextLine();
	        		break;
	        		
	        		
	        	case 5:
							exibirTitulo("CADASTRO FILA");
	        		input.nextLine();
	        		System.out.print("Nome: ");
	        		nome = input.nextLine();
	        		System.out.print("Contato: ");
	        		String contato = input.nextLine();
	        		System.out.print("Codigo do livro: ");
	        		int codLivro = input.nextInt();
	        		Pessoa novaPessoa = new Pessoa(nome, contato, codLivro);
	        		fila.add(novaPessoa);
	        		System.out.println("Cadastro realizado\n");
	        		input.nextLine();
	        		System.out.print("\nPressione ENTER para continuar!");
	        		skip = input.nextLine();
	        		break;
	        		
	        		
	        	case 6:
							exibirTitulo("LISTA DE ESPERA");
	        		if (fila.isEmpty()) {
	        			System.out.println("Não ha fila de espera");
	        		}else {
	        			System.out.print("      NOME      |    CONTATO    | COD LIVRO\n");
	        			for(Pessoa p : fila) {
	        				p.listarPessoa();	
	        			}
	        		}
	        		System.out.println();
	        		input.nextLine();
	        		System.out.print("\nPressione ENTER para continuar!");
	        		skip = input.nextLine();
	        		break;
	        		
	        	case 0:
	        		System.out.println("Encerrando Sistema");
	        		break;
	        		
	        		
	        	default: 
	        		System.out.println("Opção invalida.");
       		}      
	        System.out.println();
		}while(opcao != 0);
		input.close();
		}
	//metodo para buscar livro  
	private static Livro buscarLivro(List<Livro> livros, int codigo) {
	    	for (Livro l : livros) {
	    		if (l.getCodigo() == codigo) {
	    			return l;
	    		}
	    	}
	    	return null;
	    }
	//metodo para exibir o menu
	public static void exibirMenu(){
					System.out.println("=========== MENU ===========");
					System.out.println("1. Cadastrar novo livro");
					System.out.println("2. Listar livros");
					System.out.println("3. Retirar livro");
					System.out.println("4. Devolver livro");
					System.out.println("5. Cadastra lista de espera");
					System.out.println("6. Lista de espera");
					System.out.println("0. Sair");
					System.out.print("Escolha uma opção: ");
			}
	//metodo para exibir o titulo
	public static void exibirTitulo(String titulo){
				System.out.println("======= "+titulo+" =======");
			}
	//metodo cadastro de fila
	public static void enterContinua(Scanner input){
		System.out.print("\nPressione ENTER para continuar!");
		String skip = input.nextLine();
	}
	
}
