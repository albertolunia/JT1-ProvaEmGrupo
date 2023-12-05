package empresaEnergia;

import java.util.Date;

public class Fatura {
	
	private Date data;
	private float valor;
	private boolean quitacao;
	protected Imovel imovel;
   

	//Gets e Sets
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isQuitacao() {
		return quitacao;
	}

	public void setQuitacao(boolean quitacao) {
		this.quitacao = quitacao;
	}
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	
	
}
