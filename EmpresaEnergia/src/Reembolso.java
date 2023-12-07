package EmpresaEnergia.src;

import java.time.LocalDate;

public class Reembolso {

	private float valor;
	private LocalDate data;

	public Reembolso(float valor) {
		this.valor = valor;
		this.data = LocalDate.now();
	}

	public float getValor() {
		return valor;
	}

	public LocalDate getData() {
		return data;
	}

	@Override
	public String toString() {
		return "[valor=" + valor + ", data=" + data + "]";
	}
}
