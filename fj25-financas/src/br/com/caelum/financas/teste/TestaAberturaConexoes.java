package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TestaAberturaConexoes {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 30; i++) {
			EntityManager manager = new JPAUtil().getEntityManager();
			manager.getTransaction().begin();
			System.out.println("Criando EntityManager n�mero " + i);
		}
		
		Thread.sleep(5 * 1000);
	}

}
