package br.com.iniciativamonarca.ordemservico.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.LoginDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.model.enums.CadastrosSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.ChamadosSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.ExemploSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.OsSidebarEnum;

@Transactional
@Controller
public class LoginController {

	@Autowired
	LoginDAO funcDao;

	@RequestMapping("/")
	public String formlogin(HttpSession session) {
		return "redirect:loginForm";
	}

	@RequestMapping("/cadastros")
	public String solicitaModuloCadastros(HttpSession session,Model model) {
		Funcionario func = new Funcionario();
		model.addAttribute("listamenu", CadastrosSidebarEnum.values());
		func = (Funcionario) session.getAttribute("usuarioLogado");
		if (func.getPermissao().equals("ADMIN")) {
			return "sistema/cadastros/cadastros";
		} else
			return "redirect:eflog";
	}

	@RequestMapping("/os")
	public String solicitaModuloOs(HttpSession session,Model model) {
		model.addAttribute("listamenu", OsSidebarEnum.values());
		return "sistema/os/os";
	}


	@RequestMapping("/exemplos")
	public String solicitaModuloExemplos(HttpSession session,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		return "sistema/exemplos/exemplos";
	}

	
	@RequestMapping("/chamados")
	public String solicitaModuloChamados(HttpSession session,Model model) {
		model.addAttribute("listamenu", ChamadosSidebarEnum.values());
		return "sistema/chamados/chamados";
	}

	@RequestMapping("loginForm")
	public String solicitaLogin(HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			return "redirect:eflog";
		}
		return "sistema/login/formulario-login";
	}

	@RequestMapping("eflog")
	public String efetuaLogin(Funcionario funcionario, HttpSession session,
			HttpServletRequest req) {

		if (session.getAttribute("usuarioLogado") != null) {
			return "sistema/login/principal";
		}

		try {
			Funcionario func = funcDao.efetuarLogin(funcionario);
			if (func!= null) {
				session.setAttribute("usuarioLogado", func);
				func = (Funcionario) session.getAttribute("usuarioLogado");

				req.setAttribute("usuarioLog", func.getNome());
				req.setAttribute("usuarioPer", func.getPermissao());
				req.setAttribute("msgErro", null);
				return "sistema/login/principal";
			} else {
				req.setAttribute("msgErro", "Usuario invalido !");
				return "forward:loginForm";
			}
		} catch (DAOException e) {
			req.setAttribute("msgErro", e.getMessage());
			return "forward:loginForm";
		}

	}

	@RequestMapping("logout")
	public String efetuaLogout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}
