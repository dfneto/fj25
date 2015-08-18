package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(manager);

		Movimentacao movimentacao = dao.buscar(12);

		System.out.println(
				"O nome do titular da conta que recebeu uma movimentação é: " + movimentacao.getConta().getTitular());
		
		manager.close();
	}

}
