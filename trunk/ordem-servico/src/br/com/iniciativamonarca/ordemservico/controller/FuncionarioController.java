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
import br.com.iniciativamonarca.ordemservico.model.entity.Endereco;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;
import br.com.iniciativamonarca.ordemservico.model.enums.CadastrosSidebarEnum;

@Transactional
@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioDAO funcdao;

	
	@RequestMapping("cadastroFuncionario")
	public String cadastroFuncionario(Model model){
		model.addAttribute("listamenu", CadastrosSidebarEnum.values());
		return "sistema/cadastros/funcionario";
	}

	
	// A ordem dos argumentos tem que seguir como o metodo abaixo , pois quando eu uso o @Valid
	// tenho que colocar essa annotation em frente ao objeto e o proximo argumento tem que ser o BindingResult,se tiver
	// qualquer argumento depois do objeto sem ser o bindingResult ele n�o funciona
	@RequestMapping("adicionaFuncionario")
	public String adicionaFuncionario(@Valid Funcionario funcionario,BindingResult result,Endereco endereco,
			                          Model model,RedirectAttributes redirectAttributes) {
		
		if (!result.hasErrors()) {
			// Retirar os valores em branco das listas 
			List<String> celulares = new ArrayList<String>();
		    List<String> telefones = new ArrayList<String>();

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
		  
		    funcionario.setEndereco(endereco);
		    funcionario.setCelulares(celulares);
		    funcionario.setTelefones(telefones);
		    
		    // Criptografar Senha 
		    try {
				funcionario.setSenha(Criptografia.encriptarSenha(funcionario.getSenha(),"MD5"));
			} catch (NoSuchAlgorithmException e) {
				System.out.println("Erro ao Criptografar senha !");
				e.printStackTrace();
			}
		    
		    funcdao.adicionar(funcionario);
		    
		    redirectAttributes.addFlashAttribute("mensagem", "Funcion�rio "+ funcionario.getNome().split(" ")[0] +" salvo com sucesso!");
		    
			return "redirect:cadastroFuncionario";
		}else{
			model.addAttribute("telefone_1", funcionario.getTelefones().get(0).toString());
			model.addAttribute("telefone_2", funcionario.getTelefones().get(1).toString());
			model.addAttribute("celular_1", funcionario.getCelulares().get(0).toString());
			model.addAttribute("celular_2", funcionario.getCelulares().get(1).toString());
			
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
