package EmpresaEnergia.src;

import java.time.LocalDate;

public abstract class Falha {
	private String matricula;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	//Construtor
	public Falha(String descricao) {
		this(descricao, "");
	}
	public Falha(String descricao, String matricula) {
		this.descricao = descricao;
		this.matricula = matricula;
		this.dataInicio = LocalDate.now();
		this.dataFim = null;
	}
	//Gets e Sets
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	// data de inicio nao pode ser alterada
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	protected void consertarFalha() {
		dataFim = LocalDate.now();
	}

	// matricula nao pode ser alterada
	public String getMatricula() {
		return matricula;
	}
	
	@Override
	public String toString() {
		return "[matricula=" + matricula + ", descricao=" + descricao + ", dataInicio=" + dataInicio
				+ ", dataFim=" + dataFim + "]";
	}

}
