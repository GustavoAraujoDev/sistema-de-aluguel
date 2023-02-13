package entidades;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class veiculoslocados{
      private String cpf;
      private String placa;
      private Integer dias;
      public static ArrayList <veiculoslocados> listaDeVeiculoslocados = new ArrayList();
      public veiculoslocados() {
    	  
      }
	public veiculoslocados(String cpf, String placa, Integer dias) {
		this.cpf = cpf;
		this.placa = placa;
		this.dias = dias;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	
	public ArrayList<veiculoslocados> getListaDeVeiculoslocados() {
		return listaDeVeiculoslocados;
	}
	
	
	@Override
	public String toString() {
		return "---veiculoslocados---\n"
	           + "cpf: " + cpf + "\n"
			   + "placa: " + placa + "\n" 
	           + "dias: " + dias;
	}
	
	
	public void cadastrarVeiculosLocados(veiculoslocados veiculoslocado) {
	listaDeVeiculoslocados.add(veiculoslocado);
	System.out.println("veiculo locado com sucesso!");
	}
	
	
	public static void comfirmacoesVeiculo (char Confirmacao, veiculoslocados veiculolocado) {
		if (Confirmacao == 's') {
			veiculolocado.cadastrarVeiculosLocados(veiculolocado);
		} else {
			System.out.println("veiculo nao locado!!");
		}
	}
	

	public static void listaDeLocacao() {
		for (veiculoslocados listaDeLocação : listaDeVeiculoslocados) {
			System.out.println(listaDeLocação.toString());
		}
	}
	

	public static void dadosLocação() throws ParseException {
		Scanner entrada = new Scanner(System.in);
		System.out.print("digite a placa:");
		String placa1 = entrada.nextLine();
		veiculos.verificacoesPlaca(placa1);
		System.out.print("cpf: ");
		String cpf1 = entrada.nextLine();
		clientes.verificacoesCpf(cpf1);
		System.out.print("quantos dias vai alugar: ");
		Integer dias = entrada.nextInt();
		System.out.println();
		veiculos.confimacoesVeiculo(placa1);
		clientes.comfirmacoesCliente(cpf1);
		System.out.println();
		System.out.print("deseja confimar a locação (s/n):");
		entrada.nextLine();
		char confimacao = entrada.next().charAt(0);
		
		veiculoslocados veiculolocado = new veiculoslocados(placa1, cpf1, dias);
		veiculoslocados.comfirmacoesVeiculo(confimacao, veiculolocado);
	}
}