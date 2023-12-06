package EmpresaEnergia.src;


public class Imovel {

   private int matricula;
   private String endereco;
   private int ultLeitura,penLeitura;
	
	//Construtor
	public Imovel(int matricula, String endereco, int ultLeitura, int penLeitura) {
		super();
		this.matricula = matricula;
		this.endereco = endereco;
		this.ultLeitura = ultLeitura;
		this.penLeitura = penLeitura;
	}
	
	//Gets e Sets
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getUltLeitura() {
		return ultLeitura;
	}
	public void setUltLeitura(int ultLeitura) {
		this.ultLeitura = ultLeitura;
	}
	public int getPenLeitura() {
		return penLeitura;
	}
	public void setPenLeitura(int penLeitura) {
		this.penLeitura = penLeitura;
	}
	
	
}
