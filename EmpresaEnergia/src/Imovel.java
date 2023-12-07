package EmpresaEnergia.src;

import java.util.ArrayList;

public class Imovel {

   private String matricula;
   private String endereco;
   private float ultLeitura, penLeitura;
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
	public float realizarLeitura(float leituraAtual) {
		if (leituraAtual < this.ultLeitura) {
			return -1;
		}
		float gasto = leituraAtual - this.ultLeitura;
		this.penLeitura = this.ultLeitura;
		this.ultLeitura = leituraAtual;
		faturas.add(new Fatura(this.ultLeitura, this.penLeitura));
		System.out.println("Fatura gerada: " + faturas.get(faturas.size() - 1));
		return gasto;
	}
	
	//Gets e Sets
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	// nao existe set para matricula pois ela nao pode ser alterada
	public String getMatricula() {
		return matricula;
	}
	// nao existe set para ultLeitura e penLeitura pois eles sao atualizados pelo metodo realizarLeitura
	public float getUltLeitura() {
		return ultLeitura;
	}
	public float getPenLeitura() {
		return penLeitura;
	}

	// nao existe set para faturas e falhas pois elas sao adicionadas pelos metodos
	public ArrayList<Fatura> getFaturas() {
		return faturas;
	}
	public ArrayList<Falha> getFalhas() {
		return falhas;
	}

	public Fatura getUltimaFatura() {
		if (faturas.size() == 0) {
			return null;
		}
		return faturas.get(faturas.size() - 1);
	}

	// toString
	@Override
	public String toString() {
		return "[matricula=" + matricula + ", endereco=" + endereco + ", ultLeitura=" + ultLeitura
				+ ", penLeitura=" + String.valueOf(penLeitura) + ", numero de faturas=" + faturas.size() + ", numero de falhas=" + falhas.size() + "]";
	}

	public String toShortString(){
		return "[matricula=" + matricula + ", endereco=" + endereco + " ]";
	}
	public void addFalha(Falha falha) {
		this.falhas.add(falha);
	}

	public void ListarReparosEmAberto(){
        for (Falha falha : this.falhas) {
            if (falha instanceof FalhaDistribuicao) {
                FalhaDistribuicao falhaDistribuicao = (FalhaDistribuicao) falha;
                for (Reparo reparo : falhaDistribuicao.getReparos()) {
                    if (!reparo.isFinalizado()) {
                        System.out.print("Matricula: "+ falha.getMatricula()+ " ");
                        System.out.print(reparo.toString()+ "\n");
                    }
                }
            }
        }
    }
	public void ListarReparosEmAbertoComID(){
		int id = 0;
        for (Falha falha : this.falhas) {
            if (falha instanceof FalhaDistribuicao) {
                FalhaDistribuicao falhaDistribuicao = (FalhaDistribuicao) falha;
                for (Reparo reparo : falhaDistribuicao.getReparos()) {
					if (!reparo.isFinalizado()) {
						System.out.print("ID:"+ id + " ");
                        System.out.print(reparo.toString()+ "\n");
                    }
					id++;
                }
            }
        }
    }

	public void ListarFalhas(){
		for (Falha falha : this.falhas) {
			System.out.println(falha.toString());
		}
	}

	public void consertarFalha(int id){
		int idAtual = 0;
		for (Falha falha : this.falhas) {
			if (falha instanceof FalhaDistribuicao) {
				FalhaDistribuicao falhaDistribuicao = (FalhaDistribuicao) falha;
				for (Reparo reparo : falhaDistribuicao.getReparos()) {
					if (!reparo.isResolvido()) {
						if (id == idAtual){
							reparo.consertarReparo();
							falha.consertarFalha();
							return;
						}
					}
					idAtual++;
				}
			}
		}
	}
	public void encerraReparo(int id){
		int idAtual = 0;
		for (Falha falha : this.falhas) {
			if (falha instanceof FalhaDistribuicao) {
				FalhaDistribuicao falhaDistribuicao = (FalhaDistribuicao) falha;
				for (Reparo reparo : falhaDistribuicao.getReparos()) {
					if (!reparo.isResolvido()) {
						if (id == idAtual){
							reparo.finalizaReparo();
							return;
						}
					}
					idAtual++;
				}
			}
		}
	}

	public int getFalhaByReparo(int idReparo){
		int idAtual = 0;
		int idFalha = 0;
		for (Falha falha : this.falhas) {
			if (falha instanceof FalhaDistribuicao) {
				FalhaDistribuicao falhaDistribuicao = (FalhaDistribuicao) falha;
				for (Reparo reparo : falhaDistribuicao.getReparos()) {
					if (!reparo.isResolvido()) {
						if (idReparo == idAtual){
							
							return idFalha;
						}
					}
					idAtual++;
				}
			
			}
			idFalha++;
		}
		return -1;
	}

	public void listarPagamentos(){
		for (int i = 0; i < faturas.size(); i++) {
			faturas.get(i).listarPagamentos();
			
		}
	}
	public void listarPagamentosComID(){
		for (int i = 0; i < faturas.size(); i++) {
			System.out.print("ID: "+ i + " " + faturas.get(i));
			
		}
	}

	
	
}
