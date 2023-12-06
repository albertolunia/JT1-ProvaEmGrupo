package EmpresaEnergia.src;


import java.util.Date;

public class Falha {

	private String descricao;
	private int previsao;
	private Date dataInicio;
	private Date dataFim;
	
	//Construtor
	public Falha(String descricao, int previsao, Date dataInicio, Date dataFim) {
		super();
		this.descricao = descricao;
		this.previsao = previsao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	//Gets e Sets
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPrevisao() {
		return previsao;
	}

	public void setPrevisao(int previsao) {
		this.previsao = previsao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	

}
