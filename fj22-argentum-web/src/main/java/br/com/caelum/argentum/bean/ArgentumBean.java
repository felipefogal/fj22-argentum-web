package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.ws.ClienteWebService;

@ViewScoped
@ManagedBean
public class ArgentumBean implements Serializable {

	private List<Negociacao> negociacoes;
	
	public ArgentumBean(){
		negociacoes = new ClienteWebService().getNegociacoes();
	}
	
	public List<Negociacao> getNegociacoes(){
		return negociacoes;
	}
	
}
