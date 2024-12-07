package Biblioteca;

import BibliotecaDAO.LivroDAO;
import BibliotecaDAO.UsuarioDAO;
import BibliotecaDAO.EmprestimoDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LivroDAO livroDAO = new LivroDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

		boolean running = true;
		while (running) {
			System.out.println("Sistema da Biblioteca Universitária.");
			System.out.println("1. Cadastrar Livro");
			System.out.println("2. Cadastrar Usuário");
			System.out.println("3. Registrar Empréstimo");
			System.out.println("4. Listar Livros");
			System.out.println("5. Listar Usuários");
			System.out.println("6. Listar Empréstimos");
			System.out.println("7. Deletar Usuário");
			System.out.println("8. Deletar Livro");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha

			switch (opcao) {
			case 1:
				System.out.print("Digite o código do livro: ");
				String codigoLivro = scanner.nextLine();
				System.out.print("Digite o título do livro: ");
				String titulo = scanner.nextLine();
				System.out.print("Digite o autor do livro: ");
				String autor = scanner.nextLine();
				System.out.print("Digite o ano de publicação: ");
				String ano = scanner.nextLine();
				Livro livro = new Livro(0, codigoLivro, titulo, autor, ano);
				livroDAO.adicionarLivro(livro);
				break;
			case 2:
				System.out.print("Digite a matrícula do usuário: ");
				String matricula = scanner.nextLine();
				System.out.print("Digite o nome do usuário: ");
				String nome = scanner.nextLine();
				System.out.print("Digite o email do usuário: ");
				String email = scanner.nextLine();
				Usuario usuario = new Usuario(0, nome, matricula, email);
				usuarioDAO.adicionarUsuario(usuario);
				break;
			case 3:
				System.out.print("Digite o código do livro: ");
				codigoLivro = scanner.nextLine();
				System.out.print("Digite a matrícula do usuário: ");
				matricula = scanner.nextLine();
				System.out.print("Digite a data de empréstimo (AAAA-MM-DD): ");
				String dataEmprestimo = scanner.nextLine();
				System.out.print("Digite a data de devolução (AAAA-MM-DD): ");
				String dataDevolucao = scanner.nextLine();
				Emprestimo emprestimo = new Emprestimo(0, codigoLivro, matricula, dataEmprestimo, dataDevolucao);
				emprestimoDAO.registrarEmprestimo(emprestimo);
				break;
			case 4:
				List<Livro> livros = livroDAO.buscarTodosLivros();
				System.out.println("Livros cadastrados:");
				for (Livro l : livros) {
					System.out.println(l);
				}
				break;
			case 5:
				List<Usuario> usuarios = usuarioDAO.buscarTodosUsuarios();
				System.out.println("Usuários cadastrados:");
				for (Usuario u : usuarios) {
					System.out.println(u);
				}
				break;
			case 6:
				List<Emprestimo> emprestimos = emprestimoDAO.buscarTodosEmprestimos();
				System.out.println("Empréstimos registrados:");
				for (Emprestimo e : emprestimos) {
					System.out.println(e);
				}
				break;
			case 7:
				System.out.print("Digite a matrícula do usuário a ser deletado: ");
				int idUsuario = scanner.nextInt();
				usuarioDAO.deletarUsuario(idUsuario);
				System.out.println("Usuário deletado com sucesso!");
				break;
			case 8:
				System.out.print("Digite o ID do livro a ser deletado: ");
				int idLivro = scanner.nextInt();
				livroDAO.deletarLivro(idLivro);
				System.out.println("Livro deletado com sucesso!");
				break;
			case 0:
				running = false;
				System.out.println("Encerrando o sistema da Biblioteca Universitária...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}

		scanner.close();
	}
}
