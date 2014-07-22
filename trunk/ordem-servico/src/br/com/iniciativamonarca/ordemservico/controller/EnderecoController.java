package br.com.iniciativamonarca.ordemservico.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.iniciativamonarca.ordemservico.model.entity.Endereco;
import br.com.iniciativamonarca.ordemservico.webservices.WebServiceEndereco;

import com.google.gson.Gson;

@Controller
public class EnderecoController {
	
	@RequestMapping("consultaEndereco")
	public @ResponseBody
	String consultaEndereco(Model model,String cep) throws Exception {
		Gson gson = new Gson();
		Endereco endereco = new Endereco();
		
		endereco = WebServiceEndereco.retornaEndereco(cep);
		System.out.println(endereco);

		String json = gson.toJson(endereco);
		return json;
	}

}
