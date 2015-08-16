package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager gerenciador = fabrica.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("David");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("2488-0");
		conta.setNumero("13870-3");

		gerenciador.getTransaction().begin();
		gerenciador.persist(conta);
		gerenciador.getTransaction().commit();
		gerenciador.close();

		long fim = System.currentTimeMillis();
		System.out.println("Conta gravada com sucesso!!!!!!!");
		System.out.println("Executado em: " + (fim - inicio) + "ms");

	}

}
