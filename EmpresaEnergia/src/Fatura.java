package EmpresaEnergia.src;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fatura {
	private static float valorPorKwh = 10;
	private LocalDate data;
	private float valor;
	private boolean quitado;
	private float ultimaLeitura;
	private float penultimaLeitura;
	private ArrayList<Pagamento> pagamentos;

	// construtor
	public Fatura(float ultimaLeitura, float penultimaLeitura) {
		this.data = LocalDate.now();
		this.ultimaLeitura = ultimaLeitura;
		this.penultimaLeitura = penultimaLeitura;
		this.valor = (ultimaLeitura - penultimaLeitura) * valorPorKwh;
		this.quitado = false;
		this.pagamentos = new ArrayList<>();
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

	public float getUltimaLeitura() {
		return ultimaLeitura;
	}

	public float getPenultimaLeitura() {
		return penultimaLeitura;
	}

	// setters
	public void quitarFatura() {
		this.quitado = true;
	}
	
	@Override
	public String toString() {
		return "[data=" + data + ", valor=" + String.valueOf(valor) + ", gasto = " + String.valueOf(ultimaLeitura - penultimaLeitura) + ", quitadao =" + quitado + 
		"]";
	}

	public Pagamento getUltimoPagamento() {
		return pagamentos.get(pagamentos.size() - 1);
	}

	// metodos
	// retorna o valor a ser pagado
	public float calcularValorPendente(){
		float valorPendente = valor;
		for (Pagamento pagamento : pagamentos) {
			valorPendente -= pagamento.getValor();
		}
		return valorPendente;
	}
 

	public void addPagamento(Pagamento pagamento) {
		pagamentos.add(pagamento);
		float valorPendente = calcularValorPendente();
		if (valorPendente <= 0)
			quitarFatura();
		if (valorPendente < 0)
			pagamento.addReembolso(new Reembolso(-valorPendente));
		
		
	}

	public void listarPagamentos() {
		for (Pagamento pagamento : pagamentos) {
			System.out.println(pagamento.toString());
		}
	}

	public void listarReembolso(){
		Pagamento ultimo = getUltimoPagamento();
		if(ultimo == null){
			System.out.println("Nao ha reembolso");
			return;
		}else{
			System.out.println("Reembolso: " + ultimo.getReembolso() );
		}
	}
	
}
