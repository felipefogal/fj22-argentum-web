package br.com.caelum.argentum.grafico;

import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModelGrafico {

	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;
	private SerieTemporal serie;

	public GeradorModelGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new LineChartModel();
	}
	
	public void plotaIndicador(Indicador indicador) {
		LineChartSeries chartSerie = new LineChartSeries(indicador.toString());
		
		for (int i = comeco; i<= fim; i++) {
			double valor = indicador.calcula(i, serie);
			chartSerie.set(i, valor);
		}
		this.modeloGrafico.addSeries(chartSerie);
		this.modeloGrafico.setLegendPosition("w");
		this.modeloGrafico.setTitle("Indicadores");
	}
	
	public ChartModel getModeloGrafico() {
		return this.modeloGrafico;
	}
	
}
