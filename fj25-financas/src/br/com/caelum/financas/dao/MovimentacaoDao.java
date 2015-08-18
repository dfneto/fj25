package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void adicionar(Movimentacao movimentacao) {
		this.manager.persist(movimentacao);
	}
	
	public Movimentacao buscar(Integer id){
		return this.manager.find(Movimentacao.class, id);
	}
	
	public List<Movimentacao> listar(){
		return this.manager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}
	
	public void remover(Movimentacao movimentacao){
		this.manager.remove(movimentacao);
	}

}
