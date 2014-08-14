package br.com.iniciativamonarca.ordemservico.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.model.enums.CadastrosSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.ChamadosSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.ExemploSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.OsSidebarEnum;


@Transactional
@Controller
public class ModuloController {
	
	@RequestMapping("/moduloCadastros")
	public String abreModuloCadastros(HttpSession session,Model model) {
		Funcionario func = new Funcionario();
		model.addAttribute("listamenu", CadastrosSidebarEnum.values());
		func = (Funcionario) session.getAttribute("usuarioLogado");
		if (func.getPermissao().equals("ADMIN")) {
			return "sistema/cadastros/cadastros";
		} else
			return "redirect:efetualogin";
	}
	
	@RequestMapping("/moduloChamados")
	public String abreModuloChamados(HttpSession session,Model model) {
		model.addAttribute("listamenu", ChamadosSidebarEnum.values());
		return "sistema/chamados/chamados";
	}
	
	@RequestMapping("/moduloOs")
	public String abreModuloOs(HttpSession session,Model model) {
		model.addAttribute("listamenu", OsSidebarEnum.values());
		return "sistema/os/os";
	}
	
	
	@RequestMapping("/moduloExemplos")
	public String abreModuloExemplos(HttpSession session,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		return "sistema/exemplos/exemplos";
	}
	

}
