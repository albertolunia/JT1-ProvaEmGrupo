package EmpresaEnergia.src;


import java.time.LocalDate;
import java.util.Date;

public class Reparo {
	
	private boolean resolvido;
	private String descricao;
	private int previsao;
	private LocalDate dataInicio;	
	private LocalDate dataFim;



	public Reparo(String descricao, int previsao, LocalDate dataInicio) {
		super();
		this.setResolvido(false);
		this.descricao = descricao;
		this.previsao = previsao;
		this.dataInicio = dataInicio;
		this.dataFim = null;


	}

	public boolean isResolvido() {
		return resolvido;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	public void consertarReparo(){
		this.setResolvido(true);
		this.dataFim = LocalDate.now();
	}
	public void finalizaReparo(){
		this.dataFim = LocalDate.now();
	}
	public boolean isFinalizado(){
		return this.dataFim != null;
	}

	
	@Override
	public String toString() {
		return "[resolvido=" + resolvido + ", descricao=" + descricao + ", previsao=" + previsao
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}
}
