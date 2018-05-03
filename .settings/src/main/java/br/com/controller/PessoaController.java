
package br.com.controller;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.model.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaController")
public class PessoaController {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	
	
	public void carregarPessoas() {
		
		listaPessoas =  daoGeneric.getListEntity(Pessoa.class);
		
	}
	
	public String salvar() {
		pessoa = daoGeneric.merge(pessoa);
	    carregarPessoas();
	    
		return "";
	}


	public String novo () {
		pessoa = new Pessoa();	    
	    carregarPessoas();
		return "";
	}


	public String remove() {
	
		daoGeneric.deletePorId(pessoa);
	    pessoa = new Pessoa();
	    carregarPessoas();
		return "";
	}


	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}



	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
	
}
