package br.com.iniciativamonarca.ordemservico.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.model.entity.Usuario;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {

		String uri = request.getRequestURI();

		if (uri.endsWith("loginForm") || uri.endsWith("eflog")
				|| uri.contains("resources")) {
			if (request.getSession().getAttribute("usuarioLogado") != null) {
				Funcionario func = (Funcionario) request.getSession()
						.getAttribute("usuarioLogado");
				request.setAttribute("usuarioLog", func.getNome());
				request.setAttribute("usuarioPer", func.getPermissao());
			}
			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {

			Funcionario usu = (Funcionario) request.getSession().getAttribute(
					"usuarioLogado");
			request.setAttribute("usuarioLog", usu.getNome());
			request.setAttribute("usuarioPer", usu.getPermissao());

			return true;
		}
		response.sendRedirect("loginForm");
		return false;
	}

}
