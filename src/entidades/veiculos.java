package entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import aplicação.validarplaca;

public class veiculos {
	
     private String modelo;
     private Integer ano;
     private static String placa;
     private Double mensal;
     public static ArrayList <veiculos> listaDeVeiculos = new ArrayList();
     public veiculos() {
   
     }

	public veiculos(String modelo, Integer ano, String placa, Double mensal) {
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.mensal = mensal;
	}


	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getMensal() {
		return mensal;
	}

	public void setMensal(Double mensal) {
		this.mensal = mensal;
	}

	public ArrayList<veiculos> getListaDeVeiculos() {
		return listaDeVeiculos;
	}

	
	@Override
	public  String toString() {
		return "Modelo: " + modelo + "\n"
				+ "Ano: " + ano + "\n"
				+ "Placa: " + placa + "\n"
				+ "Mensal: " + mensal;
	}

	
	public void cadastrarveiculo (veiculos veiculo) {
		listaDeVeiculos.add(veiculo);
		System.out.println("veiculo cadastrado com sucesso!!");
	  }

	
	public static void validacoesPlaca (String Placa) {
		Scanner entrada = new Scanner (System.in);
		if (validarplaca.validaPlaca(Placa) == true) {
			for (veiculos validarVeiculo : listaDeVeiculos) {
				if (validarVeiculo.getPlaca().equals(Placa)) {
					System.out.println("veiculo ja cadastrado!!");
					break;
				}
			}
		} else {
			System.out.println("Erro, placa invalida!!");
			for (int i = 0; i < 100000; i++) {
				if (validarplaca.validaPlaca(Placa) == false) {
					System.out.print("digite novamente a placa: ");
					Placa = entrada.nextLine();
					for (veiculos validarVeiculo : listaDeVeiculos) {
						if (validarVeiculo.getPlaca().equals(Placa)) {
							System.out.println("veiculo ja cadastrado!!");
							System.out.print("digite novamente a placa: ");
							Placa = entrada.nextLine();
							break;
						}
					}
				}
			}

		}
	}
	
	
	public static void verificacoesPlaca (String Placa) {
		for (veiculos verificarVeiculo : listaDeVeiculos) {
			if (verificarVeiculo.getPlaca().equals(Placa)) {

			} else {
				break;
			}
		}
	}
	
	public static void confimacoesVeiculo (String Placa) {
		for (veiculos confirmarVeiculo : listaDeVeiculos) {
			if (confirmarVeiculo.getPlaca().equals(Placa)) {
				System.out.println(confirmarVeiculo.toString());
			}
		}
	}
	
	
	public static void dadosVeiculos () {
		Scanner entrada = new Scanner(System.in);
		System.out.print("modelo: ");
		String model = entrada.nextLine();
		System.out.print("ano: ");
		int ano = entrada.nextInt();
		System.out.print("placa: ");
		entrada.nextLine();
		String placa = entrada.nextLine();
		veiculos.validacoesPlaca(placa);
		System.out.print("valor mensal: ");
		double mensal = entrada.nextDouble();

		veiculos veiculo = new veiculos(model, ano, placa, mensal);
		veiculo.cadastrarveiculo(veiculo);
		
	} 
}