package br.com.iniciativamonarca.ordemservico.teste;

import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.LoginDAOImpl;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class Testes {

	@Autowired
	LoginDAOImpl funcdao;

	@Test
	public void EfetuarLogin() {
		try {
			Funcionario func = new Funcionario();

			func.setEmail("hailtonnegocios@gmail.com");
			func.setSenha("12345");

			List<Funcionario> f = funcdao.efetuarLogin(func);

			System.out.println(f.get(0).getEmail().toString());
			System.out.println(f.get(0).getSenha().toString());

		} catch (DAOException e) {
			System.out.println(e);
		}

	}

	@Ignore
	public void AdicionaFuncionario() {
		Funcionario func = new Funcionario();

		func.setNome("Roberto");
		func.setRg("36.300.041-0");
		func.setCpf("390.323.088-07");
		func.setEndereco("Av. Rio Branco do Teste");
		func.setPermissao("ADMIN");
		func.setSetor("An�lise");
		func.setEmail("robertonegocios@gmail.com");
		func.setSenha("12345");

		funcdao.adicionar(func);

	}

	@Ignore
	public void AlteraFuncionario() {
		Funcionario func = new Funcionario();

		func.setId_usuario(10l);
		func.setNome("Roberto");
		func.setRg("36.300.041-0");
		func.setCpf("390.323.088-07");
		func.setEndereco("Alteracao no endereco");
		func.setPermissao("ADMIN");
		func.setSetor("An�lise");
		func.setEmail("robertonegocios@gmail.com");
		func.setSenha("123");

		funcdao.alterar(func);

	}

	@Ignore
	public void SalvarFuncionario() {
		try {
			Funcionario func = new Funcionario();

			// func.setId_usuario(10l);
			func.setNome("Junior");
			func.setRg("36.300.041-0");
			func.setCpf("390.323.088-07");
			func.setEndereco("Av. Silvio Junior");
			func.setPermissao("ADMIN");
			func.setSetor("Compra");
			func.setEmail("juniornegocios@gmail.com");
			func.setSenha("123");

			Assert.assertNotNull(func);

			Assert.assertNotNull(func.getNome());
			Assert.assertNotNull(func.getEmail());
			Assert.assertNotNull(func.getSenha());
			Assert.assertNotNull(func.getPermissao());

			funcdao.salvar(func);
		} catch (DAOException e) {
			System.out.println(e);
		}

	}

	@Test
	public void BuscaPorId() {
		try {
			Funcionario func = new Funcionario();
			func.setId_usuario(1l);

			Assert.assertNotNull(func);
			Assert.assertNotNull(func.getId_usuario());

			Funcionario f = funcdao.buscarPorId(func.getId_usuario());

			System.out.println(f.getId_usuario());
			System.out.println(f.getNome());
			System.out.println(f.getRg());
			System.out.println(f.getCpf());
			System.out.println(f.getEndereco());
			System.out.println(f.getPermissao());
			System.out.println(f.getSetor());
			System.out.println(f.getEmail());
			System.out.println(f.getSenha());

		} catch (DAOException e) {
			System.out.println(e);
		}

	}

	@Ignore
	public void Remover() {
		try {
			Funcionario func = new Funcionario();
			func.setId_usuario(15l);

			Assert.assertNotNull(func);
			Assert.assertNotNull(func.getId_usuario());

			funcdao.remover(func);
		} catch (DAOException e) {
			System.out.println(e);
		}

	}

	@Test
	public void Listar() {
		try {
			List<Funcionario> f = funcdao.listar();

			for (Funcionario func : f) {
				System.out.println(func.getNome());
				System.out.println(func.getSenha());
				System.out.println(func.getEmail());
				System.out.println(func.getPermissao());
				System.out.println(func.getId_usuario());
				System.out.println(func.getCpf());
				System.out.println(func.getRg());
				System.out.println(func.getEndereco());
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*
	 * @Test public void testaUmMetodoQualquer(){ int
	 * valorQueMeuMetodoDeveRetornar1 = 10; int valorQueMeuMetodoDeveRetornar2 =
	 * 20; assertEquals(valorQueMeuMetodoDeveRetornar1, umMetodoQualqu1er(1));
	 * assertEquals(valorQueMeuMetodoDeveRetornar2, umMetodoQualqu1er(2)); }
	 * 
	 * 
	 * 
	 * 
	 * private int umMetodoQualqu1er(int nro) { return nro * 10; }
	 */

}
