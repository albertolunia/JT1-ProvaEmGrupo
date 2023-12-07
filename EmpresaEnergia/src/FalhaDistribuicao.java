package EmpresaEnergia.src;

import java.util.ArrayList;

public class FalhaDistribuicao extends Falha{
	private ArrayList<Reparo> reparos;

	public FalhaDistribuicao(String descricao) {
		super(descricao);
		this.reparos = new ArrayList<Reparo>();
	}
	public FalhaDistribuicao(String descricao, String matricula) {
		super(descricao, matricula);
		this.reparos = new ArrayList<Reparo>();
	}

	public ArrayList<Reparo> getReparos() {
		return reparos;
	}

	public void addReparo(Reparo reparo) {
		this.reparos.add(reparo);
	}
}
