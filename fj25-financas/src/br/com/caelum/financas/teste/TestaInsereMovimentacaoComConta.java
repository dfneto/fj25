package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereMovimentacaoComConta {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setAgencia("123-4");
		conta.setBanco("Banco caixa");
		conta.setNumero("2312321");
		conta.setTitular("Luiz");
		
		manager.persist(conta);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		//movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("DUMPA DUMPA");
		movimentacao.setValor(new BigDecimal("200"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);

		dao.adicionar(movimentacao);

		manager.close();
		
	}

}
