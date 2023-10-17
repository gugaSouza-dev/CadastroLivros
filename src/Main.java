import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		List<Livro> listaLivros = new ArrayList<>();
		Livro livro = new Livro();
		livro.autor = new Autor();

		String opcao;

		System.out.println("Bem vindo ao sistema do cadastro de Livros!");
		do {
			System.out.println("Escolha uma opção: \n 1 - Cadastrar Livro \n 2 - Listar Livro \n 0 - Sair");
			opcao = leitor.nextLine();

			switch (opcao)
			{
				case "1":
					Livro.CadastrarLivro(leitor, livro, listaLivros);
					break;
				case "2":
					Livro.ListarLivros(leitor, listaLivros);
					break;
				default:
					break;
			}
		} while (!opcao.equals("0"));
	}
}