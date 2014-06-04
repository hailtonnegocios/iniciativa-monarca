package br.com.iniciativamonarca.ordemservico.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.Exemplo_1DAOImpl;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo_1;
import br.com.iniciativamonarca.ordemservico.model.enums.Exemplo_1Enum;

@Transactional
@Controller
public class Exemplo_1Controller {
	
	
	@Autowired
	Exemplo_1DAOImpl exe1;

	
	@RequestMapping("cadexemplo")
	public String FormCadExemplo(HttpSession session) {
		return "sistema/exemplo/cadexemplo";
	}
	
	@RequestMapping("addexemplo")
	public String FormCadastro(HttpSession session,Model model) {
		
		model.addAttribute("myEnum",Exemplo_1Enum.values());
		return "sistema/exemplo/addexemplo";
	}
	
	@RequestMapping("delexemplo")
	public String deletar(Exemplo_1 exemplo){
		try {
			exe1.remover(exemplo);
		} catch (DAOException e) {
			System.out.println("Erro ao deletar");
		}
		
		return "redirect:listexemplo";
	}
	
	
	@RequestMapping("mostrarexemplo")
	public String mostra(Long id,Model model){
		try {
			model.addAttribute("myEnum",Exemplo_1Enum.values());
			model.addAttribute("list",exe1.buscarPorId(id));
		} catch (DAOException e) {
			System.out.println("Erro na altera��o !");
		}
		
		return "sistema/exemplo/altexemplo";
	}
	
	
	@RequestMapping("alteraexemplo")
	public String Formalterar(Exemplo_1 exemplo,Model model){
		exe1.alterar(exemplo);
		
		return "redirect:listexemplo";
	}
	
	
	@RequestMapping("listexemplo")
	public String FormList(HttpSession session,Model model) {
		List<Exemplo_1> lista_exemplo =  exe1.listar();
		model.addAttribute("lista",lista_exemplo);
		return "sistema/exemplo/listexemplo";
	}

	@RequestMapping("addexe1")
	public String Adicionar(HttpSession session,Exemplo_1 exemplo1) {
		
		if (exemplo1.getDat_cad() != null) {
			
			Calendar data = Calendar.getInstance();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.format(exemplo1.getDat_cad().getTime());
			
			data.setTime(sdf.getCalendar().getTime());
			
			exemplo1.setDat_cad(data);
		}
		
		exe1.adicionar(exemplo1);
		return "redirect:cadexemplo";
	}

	
	
	// Exemplos Ajax
	
	
	@RequestMapping("cadajax")
	public String FormAjax(HttpSession session) {
		return "sistema/exemplo/cadajax";
	}

	

}
