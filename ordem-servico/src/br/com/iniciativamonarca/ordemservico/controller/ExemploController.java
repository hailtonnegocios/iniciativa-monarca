package br.com.iniciativamonarca.ordemservico.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.ExemploDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo;
import br.com.iniciativamonarca.ordemservico.model.enums.TamanhosEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.ExemploSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.TipoProdutoEnum;

import com.google.gson.Gson;

@Transactional
@Controller
public class ExemploController {
	
	@Autowired
	ExemploDAO exemploDao;
	
	@RequestMapping("cadastroExe")
	public String cadastroExemplo(HttpSession session,Model model) {
	model.addAttribute("listamenu", ExemploSidebarEnum.values());
  	  return "sistema/exemplos/cadexemplo";
	}
	
	@RequestMapping("adicionaExe")
	public String adicionaExemplo(HttpSession session,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		model.addAttribute("myEnum",TamanhosEnum.values());
		model.addAttribute("tiposProdutos",TipoProdutoEnum.values());
		return "sistema/exemplos/addexemplo";
	}
	
	@RequestMapping("deletaExe")
	public String deletaExemplo(Exemplo exemplo,Model model){
		try {
			exemploDao.remover(exemplo);
		} catch (DAOException e) {
			System.out.println("Erro ao deletar");
		}
		return "redirect:listaExe";
	}
	
	@RequestMapping("mostraExe")
	public String mostraExemplo(Long id,Model model){
		try {
			model.addAttribute("listamenu", ExemploSidebarEnum.values());
			
			model.addAttribute("myEnum",TamanhosEnum.values());
			model.addAttribute("tiposProdutos",TipoProdutoEnum.values());
			model.addAttribute("exemplo1Selecionado",exemploDao.buscarPorId(id));
		} catch (DAOException e) {
			System.out.println("Erro na alteração !");
		}
		return "sistema/exemplos/altexemplo";
	}
	
	@RequestMapping("alteraExe")
	public String alteraExemplo(Exemplo exemplo,Model model){
		exemploDao.alterar(exemplo);
		return "redirect:listaExe";
	}
	
	@RequestMapping("listaExe")
	public String listaExemplo(HttpSession session,Model model) {
		List<Exemplo> lista_exemplo =  exemploDao.listar();
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		model.addAttribute("lista",lista_exemplo);
		return "sistema/exemplos/listexemplo";
	}

	@RequestMapping("salvaExe")
	public String salvaExemplo(HttpSession session,Exemplo exemplo1,Model model) {
		if (exemplo1.getDat_cad() != null) {

			Calendar data = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.format(exemplo1.getDat_cad().getTime());
			data.setTime(sdf.getCalendar().getTime());
			
			exemplo1.setDat_cad(data);
		}
		exemploDao.adicionar(exemplo1);
		return "redirect:cadastroExe";
	}
	
	// Exemplos Ajax
	
	@RequestMapping("cadastroAjax")
	public String cadastroAjax(HttpSession session,Model model) {
		model.addAttribute("listamenu", ExemploSidebarEnum.values());
		return "sistema/exemplos/cadajax";
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
		Exemplo exemplo = new Exemplo();
		
		exemplo.setId_exemplo(1L);
		exemplo.setNome("Produto Teste");
		exemplo.setTamanhos(TamanhosEnum.MEDIO);
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
		List<Exemplo> exemplo = exemploDao.listar();
		String lista = gson.toJson(exemplo);
		return lista; 
	}
}
