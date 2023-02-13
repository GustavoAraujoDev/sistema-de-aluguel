package entidades;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import aplicação.validarcpf;
import aplicação.validarplaca;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public class clientes {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static ArrayList<clientes> listaDeClientes = new ArrayList();
	Scanner entrada = new Scanner(System.in);
	private String nome;
	private String sexo;
	private Date datanasc;
	private String CPF;
	

	public clientes() {

	}

	public clientes(String nome, String sexo, Date datanasc, String cPF) {
		this.nome = nome;
		this.sexo = sexo;
		this.datanasc = datanasc;
		CPF = cPF;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date datanasc) {
		this.datanasc = datanasc;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public ArrayList<clientes> getListaDeClientes() {
		return listaDeClientes;
	}

	
	public String toString() {
		return "Nome: " + nome + "\n" 
			   +"Cpf: " + CPF + "\n" 
	           +"Sexo: " + sexo +  "\n" 
			   +"Data de Nascimento: " + sdf.format(datanasc);
	          
	}

	
	public void cadastrarclientes(clientes cliente) {
		listaDeClientes.add(cliente);
		System.out.println("cliente cadastrado com sucesso!!");
	}

	
	public static void validacoesCpf(String CPF) {
	Scanner entrada = new Scanner (System.in);
	if (validarcpf.isCPF(CPF) == true) {
		for (clientes validarCliente : listaDeClientes) {
			if (validarCliente.getCPF().equals(CPF)) {
				System.out.println("veiculo ja cadastrado!!");
			    System.out.print("digite novamente o cpf: "); 
				CPF = entrada.nextLine();;
				break;
			}
		}
	} else {
		System.out.printf("Erro, CPF invalido !!!\n");
		for (int i = 0; i < 100000; i++) {
			if (validarcpf.isCPF(CPF) == false) {
				System.out.print("digite novamente o cpf: ");
				CPF = entrada.nextLine();
				for (clientes validarCliente : listaDeClientes) {
					if (validarCliente.getCPF().equals(CPF)) {
						System.out.println("veiculo ja cadastrado!!");
						System.out.print("digite novamente o cpf: ");
						CPF = entrada.nextLine();
						break;
					}
				}
			}
		}
	}
}
	
	
	public static void verificacoesCpf(String Cpf) {
		for (clientes verificarCliente : listaDeClientes) {
			if (verificarCliente.getCPF().equals(Cpf)) {

			} else {
             break;		}
		}
	}
	
	
	public static void comfirmacoesCliente (String Cpf) throws ParseException {
		Scanner entrada = new Scanner(System.in);
		for (clientes confirmarCliente : listaDeClientes) {
			if (confirmarCliente.getCPF().equals(Cpf)) {
				System.out.println(confirmarCliente.toString());
			}else {
				System.out.println("cliente nao cadastrado!!");
				System.out.print("deseja se cadastrar??(s/n)");
				char confimacao = entrada.next().charAt(0);
				if(confimacao == 's') {
					clientes.dadosClientes();
				}else {
					break;
				}
			}
		}
	}
	
	
	public static void dadosClientes() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner entrada = new Scanner(System.in);
		System.out.print("nome: ");
		String nome = entrada.nextLine();
		System.out.print("cpf: ");
		String CPF = entrada.nextLine();
		clientes.validacoesCpf(CPF);
		System.out.print("sexo: ");
		String sexo = entrada.nextLine();
		System.out.print("data de nascimento: ");
		Date datan = sdf.parse(entrada.next());
		
		clientes cliente = new clientes(nome, sexo, datan, CPF);
		cliente.cadastrarclientes(cliente);
	}
}