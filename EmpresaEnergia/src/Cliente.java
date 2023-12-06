package EmpresaEnergia.src;

import java.util.ArrayList;


public class Cliente {
	private String cpf;
	private String nome;
	private ArrayList<Imovel> imoveis;

	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
		this.imoveis = new ArrayList<>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void alterarCliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente " + nome + " CPF= " + cpf + ", Imoveis=" + imoveis;
	}

	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}

	public boolean addImovel(Imovel imovel) {
		return imoveis.add(imovel);
	}
}