package br.com.iniciativamonarca.ordemservico.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.model.dao.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.LoginDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;

@Transactional
@Controller
public class LoginController {

	@Autowired
	LoginDAO FuncDao;

	@RequestMapping("/")
	public String Form(HttpSession session) {
		return "redirect:loginForm";
	}

	@RequestMapping("/cadastros")
	public String FormCad(HttpSession session) {
		Funcionario func = new Funcionario();
		func = (Funcionario) session.getAttribute("usuarioLogado");
		if (func.getPermissao().equals("ADMIN")) {
			return "sistema/cadastros";
		} else
			return "redirect:eflog";
	}

	@RequestMapping("/os")
	public String FormOS(HttpSession session) {
		return "sistema/os";
	}


	@RequestMapping("/modelos")
	public String FormCrudTeste(HttpSession session) {
		return "sistema/modelos";
	}

	
	@RequestMapping("/chamados")
	public String FormChamados(HttpSession session) {
		return "sistema/chamados";
	}

	@RequestMapping("loginForm")
	public String loginForm(HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			return "redirect:eflog";
		}
		return "sistema/formulario-login";
	}

	@RequestMapping("eflog")
	public String efetuaLogin(Funcionario funcionario, HttpSession session,
			HttpServletRequest req) {

		if (session.getAttribute("usuarioLogado") != null) {
			return "sistema/principal";
		}

		try {
			if (!FuncDao.efetuarLogin(funcionario).isEmpty()) {
				List<Funcionario> f = FuncDao.efetuarLogin(funcionario);
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
				return "sistema/principal";
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
