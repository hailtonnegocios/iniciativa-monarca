package br.com.iniciativamonarca.ordemservico.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.model.dao.Exemplo_1DAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo_1;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo_1Enum;

@Transactional
@Controller
public class Exemplo_1Controller {
	
	
	@Autowired
	Exemplo_1DAO exe1;
	
	
	@RequestMapping("exemplo1")
	public String Form(HttpSession session,Model model) {
		
		model.addAttribute("myEnum",Exemplo_1Enum.values());
		return "sistema/exemplo1";
	}
	
	
	@RequestMapping("exemplo2")
	public String For2(HttpSession session,Model model) {
		
		model.addAttribute("myEnum",Exemplo_1Enum.values());
		return "sistema/exemplo1";
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
		return "redirect:exemplo1";
	}
	

}
