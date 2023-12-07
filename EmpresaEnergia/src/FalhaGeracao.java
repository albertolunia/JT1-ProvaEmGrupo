package EmpresaEnergia.src;


public class FalhaGeracao extends Falha{

	public FalhaGeracao(String descricao, String previsao) {
		super(descricao, previsao);
	}
	public FalhaGeracao(String descricao, String previsao, String matricula) {
		super(descricao, previsao, matricula);
	}

	public void consertarFalha() {
		if (this.getDataFim() == null)
			this.consertarFalha();
	}
	

}
