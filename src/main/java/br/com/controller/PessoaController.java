
package br.com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.model.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaController")
public class PessoaController {

	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	
	
	
	public String salvar() {
		daoGeneric.salvar(pessoa);
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
	
	
}
