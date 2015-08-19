package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveConta {
	
	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		ContaDao dao = new ContaDao(manager);
		
		Conta conta = dao.buscar(12);
		
		manager.getTransaction().begin();
		
		dao.remover(conta);
		
		manager.getTransaction().commit();
		
		manager.close();
	}

}
