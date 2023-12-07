package EmpresaEnergia.src;


public class FalhaGeracao extends Falha{

	public FalhaGeracao(String descricao) {
		super(descricao);
	}
	public FalhaGeracao(String descricao, String matricula) {
		super(descricao, matricula);
	}

	public void consertarFalha() {
		if (this.getDataFim() == null)
			this.consertarFalha();
	}
	

}
