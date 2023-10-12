import java.util.Scanner;

public class Utils {
	public static String InputUsuario(String mensagem, Scanner leitor)
	{
		String input;

		System.out.print(mensagem);
		input = leitor.nextLine();
		return input;
	}

	public static Float InputUsuarioFloat(String mensagem, Scanner leitor)
	{
		float valor;
		String input;

		System.out.print(mensagem);
		input = leitor.nextLine();
		try {
			valor = Float.parseFloat(input);
		}
		catch(Exception e) {
			System.out.println("Valor informado precisa ser um valor numérico.");
			return null;
		}
		return valor;
	}
}
