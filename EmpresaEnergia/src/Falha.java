package EmpresaEnergia.src;

import java.time.LocalDate;

public abstract class Falha {
	private String matricula;
	private String previsao;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	
	//Construtor
	public Falha(String descricao, String previsao) {
		this(descricao, previsao, "");
	}
	public Falha(String descricao, String previsao, String matricula) {
		this.descricao = descricao;
		this.previsao = previsao;
		this.matricula = matricula;
		this.dataInicio = LocalDate.now();
	}

	//Gets e Sets
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrevisao() {
		return previsao;
	}

	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}

	// data de inicio nao pode ser alterada
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	public void consertarFalha() {
		this.dataFim = LocalDate.now();
	}

	// matricula nao pode ser alterada
	public String getMatricula() {
		return matricula;
	}
	

}
