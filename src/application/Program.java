package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.print("Quantos funcionários serão registrados? ");
		int n = in.nextInt();
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.println("Funcionário #" + i + ":");
			System.out.print("Id: ");
			Integer id = in.nextInt();
			in.nextLine();
			System.out.print("Nome: ");
			String nome = in.nextLine();
			System.out.print("Salário: ");
			Double salario = in.nextDouble();
			System.out.println();
			Funcionario funcionario = new Funcionario(id, nome, salario);

			list.add(funcionario);
		}
		System.out.println();
		System.out.print("Entre com o id do funcionário que o salário será aumentado: ");
		int idFuncionario = in.nextInt();
		Funcionario funcionario = list.stream().filter(x -> x.getId() == idFuncionario).findFirst().orElse(null);

		if (funcionario == null) {
			System.out.println("Este id não existe!");
		} else {
			System.out.print("Digite a porcentagem: ");
			double porcentagem = in.nextDouble();
			funcionario.aumentoSalario(porcentagem);
		}

		System.out.println();
		System.out.println("Lista de funcionários:");
		for (Funcionario x : list) {
			System.out.println(x);
		}

		in.close();
	}

}
