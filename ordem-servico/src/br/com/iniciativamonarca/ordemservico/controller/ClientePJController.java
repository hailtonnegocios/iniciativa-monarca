package br.com.iniciativamonarca.ordemservico.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ClientePJController {

	@RequestMapping ("ClientePJ")
	public String abreClientePJ (){
		return "sistema/cadastros/clientePJ";
	}
	
	
}
