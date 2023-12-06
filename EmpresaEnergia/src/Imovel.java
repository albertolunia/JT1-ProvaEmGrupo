package EmpresaEnergia.src;

import java.util.ArrayList;

public class Imovel {

   private String matricula;
   private String endereco;
   private int ultLeitura, penLeitura;
   private ArrayList<Fatura> faturas;
   private ArrayList<Falha> falhas;

// 	+ int realizarLeitura(int leituraAtual) // atualiza valores de leitura e retorna gasto do periodo
	
	//Construtor
	public Imovel(String matricula, String endereco) {
		this.matricula = matricula;
		this.endereco = endereco;
		this.ultLeitura = 0;
		this.penLeitura = 0;
		this.faturas = new ArrayList<Fatura>();
		this.falhas = new ArrayList<Falha>();
	}

	// Metodos

	// recebe a leitura atual e retorna o gasto do periodo
	// metodo atualiza os valores de ultLeitura e penLeitura
	public int realizarLeitura(int leituraAtual) {
		int gasto = leituraAtual - this.ultLeitura;
		faturas.add(new Fatura(this.ultLeitura, this.penLeitura));
		this.penLeitura = this.ultLeitura;
		this.ultLeitura = leituraAtual;
		return gasto;
	}
	
	//Gets e Sets
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	// nao existe set para ultLeitura e penLeitura pois eles sao atualizados pelo metodo realizarLeitura
	public int getUltLeitura() {
		return ultLeitura;
	}
	public int getPenLeitura() {
		return penLeitura;
	}

	// nao existe set para faturas e falhas pois elas sao adicionadas pelos metodos
	public ArrayList<Fatura> getFaturas() {
		return faturas;
	}
	public ArrayList<Falha> getFalhas() {
		return falhas;
	}


	// toString
	@Override
	public String toString() {
		return "[matricula=" + matricula + ", endereco=" + endereco + ", ultLeitura=" + ultLeitura
				+ ", penLeitura=" + String.valueOf(penLeitura) + ", numero de faturas=" + faturas.size() + ", numero de falhas=" + falhas.size() + "]";
	}



	
	
}
