import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Livro extends Autor{
	public String titulo;
	public Autor autor;
	public Float preco;
	public LocalDate dataLancamento;

	public static void CadastrarLivro(Scanner leitor, Livro livro, List<Livro> listaLivros)
	{
		System.out.println("Informe o nome do livro:");
		livro.titulo = leitor.nextLine();

		System.out.println("Informe o nome do autor:");
		livro.autor.nome = leitor.nextLine();

		System.out.println("Informe o local de nascimento do autor:");
		livro.autor.localNasc = leitor.nextLine();

		System.out.println("Informe o valor do livro:");
		livro.preco = leitor.nextFloat();

		System.out.println("Informe a data de lançamento do livro: (dd/mm/aaaa: ");
		livro.dataLancamento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		leitor.nextLine();
		if (VerificarTempoLanc(livro.dataLancamento) >= 5)
		{
			listaLivros.add(livro);
			System.out.println("Cadastro realizado!");
		}
	}

	public static int VerificarTempoLanc(LocalDate dataLancamento) {
		Period idade;

		idade = Period.between(dataLancamento, LocalDate.now());
		if (idade.getYears() < 5)
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
			System.out.println("Aperte ENTER para continuar");
			leitor.nextLine();
		}
	}
}
