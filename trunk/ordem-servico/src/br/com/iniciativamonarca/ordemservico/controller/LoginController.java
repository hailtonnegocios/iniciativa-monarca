package br.com.iniciativamonarca.ordemservico.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.ConnectionFactory;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.LoginDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.relatorios.GeradorRelatorio;

//teste update

@Transactional
@Controller
public class LoginController {

	@Autowired
	LoginDAO usuDao;
	

	@RequestMapping("/")
	public String formlogin(HttpSession session) {
		return "redirect:loginForm";
	}

	@RequestMapping("loginForm")
	public String loginForm(HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			return "redirect:efetuaLogin";
		}
		return "sistema/login/formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Funcionario funcionario, HttpSession session,HttpServletRequest req) {
		if (session.getAttribute("usuarioLogado") != null) {
			return "sistema/login/principal";
		}
		try {
		
			funcionario = usuDao.efetuarLogin(funcionario);
			if (funcionario!= null) {
				session.setAttribute("usuarioLogado", funcionario);
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
