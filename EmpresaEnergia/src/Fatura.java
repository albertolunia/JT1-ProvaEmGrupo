package EmpresaEnergia.src;

import java.time.LocalDate;

public class Fatura {
	private static float valorPorKwh = 10;
	private LocalDate data;
	private float valor;
	private boolean quitado;
	private int ultimaLeitura;
	private int penultimaLeitura;

	// construtor
	public Fatura(int ultimaLeitura, int penultimaLeitura) {
		this.data = LocalDate.now();
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.valor = (ultimaLeitura - penultimaLeitura) * valorPorKwh;
		this.quitado = false;
	}
   

	// getters
	// atributos nao possuem setters pois sao inicializados no construtor e nao devem ser alterados
	public LocalDate getData() {
		return data;
	}

	public float getValor() {
		return valor;
	}

	public boolean isQuitado() {
		return quitado;
	}

	public int getUltimaLeitura() {
		return ultimaLeitura;
	}

	public int getPenultimaLeitura() {
		return penultimaLeitura;
	}

	// setters
	public void quitarFatura() {
		this.quitado = true;
	}
	
	
}
