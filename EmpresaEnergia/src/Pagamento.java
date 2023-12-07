package EmpresaEnergia.src;

import java.time.LocalDate;

public class Pagamento {

	private float valor;
	private LocalDate data;
	private String matricula;
	private Reembolso reembolso;

	public Pagamento(float valor, String matricula) {
		this.valor = valor;
		this.data = LocalDate.now();
		this.matricula = matricula;
		reembolso = null;
	}

	// getters
	public float getValor() {
		return valor;
	}
	public LocalDate getData() {
		return data;
	}
	public String getMatricula() {
		return matricula;
	}
	public Reembolso getReembolso() {
		return reembolso;
	}


	public void addReembolso(Reembolso reembolso) {
		if (this.reembolso == null)
			this.reembolso = reembolso;
	}

	@Override
	public String toString() {
		return "Pagamento{" +
				"valor=" + valor +
				", data=" + data +
				", matricula='" + matricula + '\'' +
				", reembolso=" + reembolso +
				'}';
	}
	
}
