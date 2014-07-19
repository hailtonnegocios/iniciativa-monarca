package br.com.iniciativamonarca.ordemservico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.model.dao.impl.FuncionarioDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.model.enums.CadastrosSidebarEnum;

@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioDAO funcdao;

	
	@RequestMapping("cadastroFuncionario")
	public String cadastroFuncionario(Model model){
		model.addAttribute("listamenu", CadastrosSidebarEnum.values());
		return "sistema/cadastros/funcionario";
	}

	@RequestMapping("adicionaFuncionario")
	public String adicionaFuncionario(@Valid Funcionario funcionario,BindingResult br) {
		return "";
	}

	@RequestMapping("mostraFuncionario")
	public String mostraFuncionario(Long id) {
		return "";
	}

	@RequestMapping("alteraFuncionario")
	public String alteraFuncionario(@Valid Funcionario funcionario,BindingResult br) {
		return "";
	}

	@RequestMapping("deletaFuncionario")
	public String deletaFuncionario(Long id) {
		return "";
	}

}
