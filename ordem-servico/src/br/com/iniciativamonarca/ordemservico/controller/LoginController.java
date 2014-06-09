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
	public String form(HttpSession session) {
		return "redirect:loginForm";
	}

	@RequestMapping("/cadastros")
	public String formCadastros(HttpSession session,Model model) {
		Funcionario func = new Funcionario();
		model.addAttribute("listamenu", CadastrosSidebarEnum.values());
		func = (Funcionario) session.getAttribute("usuarioLogado");
		if (func.getPermissao().equals("ADMIN")) {
			return "sistema/cadastros/cadastros";
		} else
			return "redirect:eflog";
	}

	@RequestMapping("/os")
	public String formOs(HttpSession session,Model model) {
		model.addAttribute("listamenu", OsSidebarEnum.values());
		return "sistema/os/os";
	}


	@RequestMapping("/exemplos")
	public String formExemplos(HttpSession session,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		return "sistema/exemplos/exemplos";
	}

	
	@RequestMapping("/chamados")
	public String formChamados(HttpSession session,Model model) {
		model.addAttribute("listamenu", ChamadosSidebarEnum.values());
		return "sistema/chamados/chamados";
	}

	@RequestMapping("loginForm")
	public String formLogin(HttpSession session) {
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
			if (!funcDao.efetuarLogin(funcionario).isEmpty()) {
				List<Funcionario> f = funcDao.efetuarLogin(funcionario);
				Funcionario func = new Funcionario();

				func.setId_usuario(f.get(0).getId_usuario());
				func.setEmail(f.get(0).getEmail());
				func.setPermissao(f.get(0).getPermissao());
				func.setSenha(f.get(0).getSenha());

				session.setAttribute("usuarioLogado", func);

				func = (Funcionario) session.getAttribute("usuarioLogado");

				req.setAttribute("usuarioLog", func.getEmail());
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
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}
