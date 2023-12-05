package empresaEnergia;

public class Clientes {

	private String cpf,nome;
	
	//Construtor
	public Clientes(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}

	//Gets e Sets
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
	
	
}
