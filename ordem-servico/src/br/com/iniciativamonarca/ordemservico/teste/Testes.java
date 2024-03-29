package br.com.iniciativamonarca.ordemservico.teste;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

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
import br.com.iniciativamonarca.ordemservico.model.dao.impl.ExemploDAO;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.FuncionarioDAO;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.LoginDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Endereco;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.webservices.WebServiceEndereco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional


// vamos colocar um teste para ver se esta linkando no google code ok

public class Testes {

	@Autowired
	LoginDAO usudao;

	@Autowired
	FuncionarioDAO funcdao;

	@Autowired
	ExemploDAO exemplodao;


	@Ignore
	public void ListarLike() {

		List<Exemplo> exe = exemplodao.listarLike("id_exemplo", "1549");
		System.out.println(exe);

		for (Exemplo func : exe) {
			System.out.println(func.getNome());
		}

	}

	
	@Test
	public void ListarLike_Funcionario() {

		List<Funcionario> exe = funcdao.listarLike("id_usuario","1");
		System.out.println(exe);

		for (Funcionario func : exe) {
			System.out.println(func.getNome());
		}

	}
	
	
	@Ignore
	public void EfetuarLogin() {
		try {
			Funcionario func = new Funcionario();

			func.setEmail("hailtonnegocios@gmail.com");
			func.setSenha("12345");

			Funcionario f = usudao.efetuarLogin(func);

			System.out.println(f.getEmail().toString());
			System.out.println(f.getSenha().toString());

		} catch (DAOException e) {
			System.out.println(e);
		}
	}

	
	@Ignore
	public void verificaFuncionario(){
		try {
			Funcionario func = new Funcionario();

			func.setEmail(null);

			if(funcdao.verificaFuncionario(func.getEmail())){
				System.out.println("Esse Email ja existe em nossa base de dados");
			}else
				System.out.println("Email n�o usado ainda");

		} catch (DAOException e) {
			System.out.println(e);
		}
	}
	
	
	@Ignore
	public void AdicionaFuncionario() {
		
		Funcionario func = new Funcionario();
        List<String> tel = new ArrayList<String>();  
        List<String> cel = new ArrayList<String>();
		
		func.setNome("Nome Teste2");
		func.setRg("36.222.112-4");
		func.setCpf("387.322.048-07");
		func.setPermissao("ADMIN");
		func.setSetor("Setor Teste2");
		func.setEmail("teste2@gmail.com");
		func.setSenha("827ccb0eea8a706c4c34a16891f84e7b");
		
        tel.add("2453-2391");
        tel.add("");
        tel.add("2451-2391");
        func.setTelefones(tel);
        
        cel.add("95449-6507");
        cel.add("98214-2921");
		func.setCelulares(cel);

		// Retorno do WebService com o Endere�o 
		try {
			String   cep = "07081-120";
			Endereco endereco = WebServiceEndereco.retornaEndereco(cep);
			
			endereco.setCep(cep);
			endereco.setNumero("280");
			endereco.setComplemento("A-19");

			func.setEndereco(endereco);
			
		} catch (MalformedURLException | JAXBException e) {
			System.out.println("Erro ao consultar WebService");
			e.printStackTrace();
		}
		
		funcdao.adicionar(func);
	}

	@Ignore
	public void AlteraFuncionario() {
		Funcionario func = new Funcionario();

		func.setId_usuario(10l);
		func.setNome("Roberto");
		func.setRg("36.300.041-0");
		func.setCpf("390.323.088-07");
		// func.setEndereco("Alteracao no endereco");
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
			// func.setEndereco("Av. Silvio Junior");
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

	@Ignore
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
			func.setId_usuario(14l);

			Assert.assertNotNull(func);
			Assert.assertNotNull(func.getId_usuario());

			funcdao.remover(func.getId_usuario());
		} catch (DAOException e) {
			System.out.println(e);
		}

	}

	@Ignore
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
