import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

public class Livro extends Autor{
	public String titulo;
	public Autor autor;
	public Float preco;
	public LocalDate dataLancamento;

	public static void CadastrarLivro(Scanner leitor, Livro livro, List<Livro> listaLivros)
	{
		livro.titulo = Input.InputUsuario("Informe o nome do livro: ", leitor);
		livro.autor.nome = Input.InputUsuario("Informe o nome do autor: ", leitor);
		livro.autor.localNasc = Input.InputUsuario("Informe o local de nascimento do autor: ", leitor);
		livro.preco = Input.InputUsuarioFloat("Informe o valor do livro, separando os centavos por ponto (.): ", leitor);
		if (livro.preco == null)
			return;
		livro.dataLancamento = Input.InputUsuarioLocalDate("Informe a data de lançamento do livro: (dd/mm/aaaa): ", leitor);
		if (livro.dataLancamento == null)
			return;
		if (VerificarTempoLanc(livro.dataLancamento) > 5)
		{
			listaLivros.add(livro);
			System.out.println("Cadastro realizado!");
		}
	}

	public static int VerificarTempoLanc(LocalDate dataLancamento) {
		Period idade;

		idade = Period.between(dataLancamento, LocalDate.now());
		if (idade.getYears() <= 5)
		{
			System.out.println("Livro muito novo. Não pode ser cadastrado.");
			return 0;
		}
		return idade.getYears();
	}

	public static void ListarLivros(Scanner leitor, List<Livro> listaLivros)
	{
		for (Livro livro : listaLivros)
		{
			System.out.println("Nome: " + livro.titulo
				+ "\nAutor: " + livro.autor.nome
				+ "\nData de nascimento do autor: " + livro.autor.localNasc
				+ "\nValor :" + livro.preco
				+ "\nData de lançamento: " + livro.dataLancamento);
			System.out.println("\nAperte ENTER para continuar");
			leitor.nextLine();
		}
	}
}
