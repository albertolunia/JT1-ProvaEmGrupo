package EmpresaEnergia.src;

import java.util.ArrayList;

public class FalhaDistribuicao extends Falha{
	private ArrayList<Reparo> reparos;

	public FalhaDistribuicao(String descricao, String previsao) {
		super(descricao, previsao);
		this.reparos = new ArrayList<Reparo>();
	}
	public FalhaDistribuicao(String descricao, String previsao, String matricula) {
		super(descricao, previsao, matricula);
		this.reparos = new ArrayList<Reparo>();
	}

	public ArrayList<Reparo> getReparos() {
		return reparos;
	}

	public void addReparo(Reparo reparo) {
		this.reparos.add(reparo);
	}

}
