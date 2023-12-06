package EmpresaEnergia.src;


import java.util.Date;

public class Reparo extends Falha {
	
	private boolean resolvido;

	public Reparo(String descricao, int previsao, Date dataInicio, Date dataFim,boolean resolvido) {
		super(descricao, previsao, dataInicio, dataFim);
		this.setResolvido(resolvido);
	}

	public boolean isResolvido() {
		return resolvido;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
}
