package br.com.iniciativamonarca.ordemservico.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iniciativamonarca.ordemservico.criptografia.Criptografia;
import br.com.iniciativamonarca.ordemservico.model.dao.impl.FuncionarioDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.model.enums.CadastrosSidebarEnum;

@Transactional
@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioDAO funcdao;

	
	@RequestMapping(value = "cadastroFuncionario")
	public String cadastroFuncionario(Model model){
		model.addAttribute("listamenu", CadastrosSidebarEnum.values());
		return "sistema/cadastros/funcionario";
	}

	
	// A ordem dos argumentos tem que seguir como o metodo abaixo , pois quando eu uso o @Valid
	// tenho que colocar essa annotation em frente ao objeto e o proximo argumento tem que ser o BindingResult,se tiver
	// qualquer argumento depois do objeto sem ser o bindingResult ele não funciona
	@RequestMapping("adicionaFuncionario")
	public String adicionaFuncionario(@Valid Funcionario funcionario,BindingResult result,Model model,
			RedirectAttributes redirectAttributes) {
		
		
		if (!result.hasErrors()) {
		
		List<String> celulares = new ArrayList<String>();
		List<String> telefones = new ArrayList<String>();
		
			// Retirar os valores em branco das listas
		    for (int i=0; i < funcionario.getCelulares().size();i++) {
		    	if(!funcionario.getCelulares().get(i).equals("")){
		    	     celulares.add(funcionario.getCelulares().get(i).toString());
		    	}
			}
		    for (int i=0; i < funcionario.getTelefones().size();i++) {
		    	if(!funcionario.getTelefones().get(i).equals("")){
		    	     telefones.add(funcionario.getTelefones().get(i).toString());
		    	}
			}
		    
		    
		    funcionario.setCelulares(celulares);
		    funcionario.setTelefones(telefones);
	
		    try {
				funcionario.setSenha(Criptografia.encriptarSenha(funcionario.getSenha(),"MD5"));
			} catch (NoSuchAlgorithmException e) {
				System.out.println("Erro ao Criptografar senha !");
				e.printStackTrace();
			}

		    funcdao.adicionar(funcionario);
		    
		    redirectAttributes.addFlashAttribute("mensagem", "Funcionário "+ funcionario.getNome().split(" ")[0] +" salvo com sucesso!");
		    
			return "redirect:cadastroFuncionario";
		}else{
			return "forward:cadastroFuncionario";
		}
	}

	@RequestMapping("mostraFuncionario")
	public String mostraFuncionario(Long id) {
		return "";
	}

	@RequestMapping("alteraFuncionario")
	public String alteraFuncionario(@Valid Funcionario funcionario,BindingResult br) {
		return "";
	}

	@RequestMapping("deletaFuncionario")
	public String deletaFuncionario(Long id) {
		return "";
	}
	

}
