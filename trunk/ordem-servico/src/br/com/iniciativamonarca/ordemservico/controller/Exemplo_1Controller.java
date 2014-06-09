package br.com.iniciativamonarca.ordemservico.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EnumType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.Exemplo_1DAOImpl;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo_1;
import br.com.iniciativamonarca.ordemservico.model.enums.ExemploSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.Exemplo_1Enum;
import br.com.iniciativamonarca.ordemservico.model.enums.TipoProdutoEnum;

import com.google.gson.Gson;

@Transactional
@Controller
public class Exemplo_1Controller {
	
	
	@Autowired
	Exemplo_1DAOImpl exemploDao;

	
	@RequestMapping("cadastroExe")
	public String cadastroExemplo(HttpSession session,Model model) {
	model.addAttribute("listamenu", ExemploSidebarEnum.values());
  	  return "sistema/exemplo/cadexemplo";
	}
	
	@RequestMapping("addexemplo")
	public String FormCadastro(HttpSession session,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		model.addAttribute("myEnum",Exemplo_1Enum.values());
		model.addAttribute("tiposProdutos",TipoProdutoEnum.values());
		return "sistema/exemplo/addexemplo";
	}
	
	@RequestMapping("delexemplo")
	public String deletar(Exemplo_1 exemplo,Model model){
		try {
			model.addAttribute("listamenu", ExemploSidebarEnum.values());
			exemploDao.remover(exemplo);
		} catch (DAOException e) {
			System.out.println("Erro ao deletar");
		}
		
		return "redirect:listexemplo";
	}
	
	
	@RequestMapping("mostrarexemplo")
	public String mostra(Long id,Model model){
		try {
			model.addAttribute("listamenu", ExemploSidebarEnum.values());
			
			model.addAttribute("myEnum",Exemplo_1Enum.values());
			model.addAttribute("tiposProdutos",TipoProdutoEnum.values());
			model.addAttribute("exemplo1Selecionado",exemploDao.buscarPorId(id));
		} catch (DAOException e) {
			System.out.println("Erro na alteração !");
		}
		
		return "sistema/exemplo/altexemplo";
	}
	
	
	@RequestMapping("alteraexemplo")
	public String Formalterar(Exemplo_1 exemplo,Model model){
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		exemploDao.alterar(exemplo);
		return "redirect:listexemplo";
	}
	
	
	@RequestMapping("listexemplo")
	public String FormList(HttpSession session,Model model) {
		List<Exemplo_1> lista_exemplo =  exemploDao.listar();
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		model.addAttribute("lista",lista_exemplo);
		return "sistema/exemplo/listexemplo";
	}

	@RequestMapping("addexe1")
	public String Adicionar(HttpSession session,Exemplo_1 exemplo1,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		if (exemplo1.getDat_cad() != null) {
			
			Calendar data = Calendar.getInstance();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.format(exemplo1.getDat_cad().getTime());
			
			data.setTime(sdf.getCalendar().getTime());
			
			exemplo1.setDat_cad(data);
		}
		
		exemploDao.adicionar(exemplo1);
		return "redirect:cadexemplo";
	}

	
	
	// Exemplos Ajax
	
	
	@RequestMapping("cadajax")
	public String FormAjax(HttpSession session,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		return "sistema/exemplo/cadajax";
	}
	
	@RequestMapping("funcajax1") 
	public void Ajax1(HttpServletResponse resp,Model model) throws IOException{
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		String nome = "Nome Teste";
		resp.getWriter().write(nome);
		resp.setStatus(200);
	}
	
	@RequestMapping("funcajax2") 
	public @ResponseBody String Ajax2(Model model)
			throws Exception{
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		Gson gson = new Gson();
		Exemplo_1 exemplo = new Exemplo_1();
		
		exemplo.setId_exemplo(1L);
		exemplo.setNome("Produto Teste");
		exemplo.setTamanhos(Exemplo_1Enum.MEDIO);
		exemplo.setDescricao("Descrição Teste");
		exemplo.setTipo(TipoProdutoEnum.COMPRA);
		exemplo.setStatus(true);
		
		Calendar cal = Calendar.getInstance();
		exemplo.setDat_cad(cal);
		
		String json = gson.toJson(exemplo);
		return json; 
	}

	@RequestMapping("funcajax3") 
	public @ResponseBody String Ajax3(Model model)
			throws Exception{
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		Gson gson = new Gson();
		List<Exemplo_1> exemplo = exemploDao.listar();
		String lista = gson.toJson(exemplo);
		return lista; 
	}
}
