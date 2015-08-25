package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();

		//EntityManager eh responsavel por gerenciar entidades no contexto de persistencia
		EntityManager manager = new JPAUtil().getEntityManager();

		ContaDao dao = new ContaDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Teste");
		conta.setBanco("Banco do teste");
		conta.setAgencia("2488-0");
		conta.setNumero("13870-3");

		manager.getTransaction().begin();

		dao.adicionar(conta);
		
		manager.getTransaction().commit();
		manager.close();

		long fim = System.currentTimeMillis();
		System.out.println("Conta gravada com sucesso!!!!!!!");
		System.out.println("Executado em: " + (fim - inicio) + "ms");

	}

}
