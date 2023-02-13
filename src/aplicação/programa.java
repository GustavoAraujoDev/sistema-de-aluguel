package aplicação;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.clientes;
import entidades.veiculos;
import entidades.veiculoslocados;

public class programa {

	public static void main(String[] args) throws ParseException {
		Scanner entrada = new Scanner(System.in);
		
		int opc = 0;

		do {
			System.out.println("\n-------------------");
			System.out.println("     MENU");
			System.out.println(" escolha uma opção");
			System.out.println("1 - cadastrar carros");
			System.out.println("2 - cadastrar clientes");
			System.out.println("3 - locaçoes de veiculos");
			System.out.println("4 - lista de localçoes");
			System.out.println("-------------------\n");
			opc = entrada.nextInt();
			entrada.nextLine();
			switch (opc) {
			case 1:
				veiculos.dadosVeiculos();
				break;
			case 2:
				clientes.dadosClientes();
				break;
			case 3:
				veiculoslocados.dadosLocação();
				break;
			case 4:
				veiculoslocados.listaDeLocacao();
			}
		} while (opc != 0);

	}

}
