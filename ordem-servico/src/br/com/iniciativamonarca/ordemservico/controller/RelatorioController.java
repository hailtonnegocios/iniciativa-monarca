package br.com.iniciativamonarca.ordemservico.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.model.dao.ConnectionFactory;
import br.com.iniciativamonarca.ordemservico.relatorios.GeradorRelatorio;


@Controller
public class RelatorioController {

	@RequestMapping("relatorioTeste")
	public void geraRelatorio(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, JRException, IOException{
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String nome = request.getServletContext().getRealPath("/WEB-INF/relatorios/usuarios.jasper");
		
		GeradorRelatorio geradorRelatorio = new GeradorRelatorio(nome, parameters , new ConnectionFactory().getConnection());
		
		geradorRelatorio.geraPDF(response.getOutputStream());
		
	}
	
	
}
