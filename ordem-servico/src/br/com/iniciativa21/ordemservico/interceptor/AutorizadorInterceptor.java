package br.com.iniciativa21.ordemservico.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.iniciativa21.ordemservico.model.entity.Usuario;


public class AutorizadorInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object controller)
	throws Exception{
		
  	   String uri = request.getRequestURI();
		
		if(uri.endsWith("loginForm") || uri.endsWith("eflog") || uri.contains("resources")){
			if(request.getSession().getAttribute("usuarioLogado") != null){
			   Usuario usu = (Usuario) request.getSession().getAttribute("usuarioLogado");
			   request.setAttribute("usuarioLog",usu.getEmail());
			   request.setAttribute("usuarioPer",usu.getPermissao());
			}
			
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado") != null){
	       
		   Usuario usu = (Usuario) request.getSession().getAttribute("usuarioLogado");
		   request.setAttribute("usuarioLog",usu.getEmail());
		   request.setAttribute("usuarioPer",usu.getPermissao());

  		   return true;
		}
		
		response.sendRedirect("loginForm");
		return false;
	}


}
