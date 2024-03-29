package br.com.iniciativamonarca.ordemservico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.model.dao.impl.ClienteDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Cliente;


@Transactional
@Controller
public class ClienteController {
		
	@Autowired
	ClienteDAO clienteDao;
	
	@RequestMapping ("Cliente")
	public String abrePaginaPrincipalCliente (){
		return "sistema/cadastros/cliente";
	}
	
	@RequestMapping ("adicionaCliente")
	public void adicionaCliente (@Valid Cliente cliente){
		System.out.println(cliente);
		clienteDao.adicionar(cliente);
	}
	

	
}
