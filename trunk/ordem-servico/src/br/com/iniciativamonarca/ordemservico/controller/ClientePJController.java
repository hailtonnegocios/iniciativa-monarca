package br.com.iniciativamonarca.ordemservico.controller;


import br.com.iniciativamonarca.ordemservico.model.dao.impl.ClientePJDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Cliente;
import br.com.iniciativamonarca.ordemservico.model.entity.ClientePJ;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ClientePJController {
    
    @Autowired
    ClientePJDAO clientePJDao;

	@RequestMapping ("ClientePJ")
	public String abreClientePJ (){
		return "sistema/cadastros/clientePJ";
	}
	
	@RequestMapping ("adicionaClientePJ")
	public String adicionaClientePJ (@Valid ClientePJ clientepj){
            clientePJDao.adicionar(clientepj);
		return "sistema/cadastros/clientePJ";
	}
	
	
}
