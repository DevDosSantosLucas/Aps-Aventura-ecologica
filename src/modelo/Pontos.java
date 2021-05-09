package modelo;

public class Pontos {
	
	public static final int ACERTOU   = 0;
	public static final int ERROU     = 1;
	
	private int calcula;
				

	//private int operacao;
	
	public Pontos() {
		calcula = 0;
	}
	
	public Pontos(Integer calcula) {
		this.calcula = calcula;
	}
	public void setOperando(int valor) {
		this.calcula = valor; 
	}		
	
	
	public void setOperacao(int op) {
		this.calcula = op;
	}
	
	public int calcular(int operacao) throws ArithmeticException {
		switch (operacao) {
		
		case ACERTOU:
			calcula = calcula + 1;
			break;
			
		case ERROU:		
			calcula = calcula - 1;
			break;
		}
		return calcula;
	}
	

	/**
	 * @return the incremento
	 */
	public int getIncremento() {
		return calcula ;
	}

	/**
	 * @param incremento the incremento to set
	 */
	public void setIncremento(int incremento) {
		this.calcula = incremento;
	}
	
}


