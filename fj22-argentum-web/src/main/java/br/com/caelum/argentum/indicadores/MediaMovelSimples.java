package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private Indicador outroIndicador;

	/* (non-Javadoc)
	 * @see br.com.caelum.argentum.indicadores.Indicador#calcula(int, br.com.caelum.argentum.modelo.SerieTemporal)
	 */
	
	public MediaMovelSimples(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		
		for (int i = posicao; i > posicao -3; i--) {
			soma += outroIndicador.calcula(i, serie);
		}
		return soma/3;
	}
	
	public String toString() {
		return "MMS de Fechamento";
	}
	
}
