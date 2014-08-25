package br.com.iniciativamonarca.ordemservico.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.iniciativamonarca.ordemservico.model.dao.impl.FuncionarioDAO;
import br.com.iniciativamonarca.ordemservico.model.enums.CadastrosSidebarEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.ListaMenuCadastrosEnum;
import br.com.iniciativamonarca.ordemservico.model.enums.TipoRelatorioEnum;
import br.com.iniciativamonarca.ordemservico.relatorios.GeradorRelatorio;


@Controller
public class RelatorioController {

	@Autowired
	FuncionarioDAO funcionario ;
	

	@RequestMapping("relatorioModuloCadastros")
	public String relatorioModuloCadastro(Model model){
		model.addAttribute("listamenu", CadastrosSidebarEnum.values());
		model.addAttribute("listaMenuCadastro", ListaMenuCadastrosEnum.values());
		model.addAttribute("listaTipoRelatorio", TipoRelatorioEnum.values());
		
		return "sistema/telas_de_relatorios/relatoriomodulocadastro";
	}	

	@RequestMapping("relatorioFuncionario")
	public void geraRelatorio(String menuModuloCadastro,String tipoRelatorioCadastro,HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, JRException, IOException{
		Map<String, Object> parameters = new HashMap<String, Object>();

		if(menuModuloCadastro.equals("funcionario") && tipoRelatorioCadastro.equals("simplificado")){
			GeradorRelatorio geradorDeRelatorio = new GeradorRelatorio("funcionarioSimplificado.jrxml",request,response,parameters);
			// Carrega lista no Relatorio para dar o Print
			JasperPrint print = geradorDeRelatorio.atribuiListaCarregadaNoRelatorio(funcionario.listar());
			// Visualiza relatorio no navegador com formato PDF
			geradorDeRelatorio.visualizarRelatorio(print,response);
		}

		if(menuModuloCadastro.equals("funcionario") && tipoRelatorioCadastro.equals("completo")){
			GeradorRelatorio geradorDeRelatorio = new GeradorRelatorio("funcionarioCompleto.jrxml",request,response,parameters);
			// Carrega lista no Relatorio para dar o Print
			JasperPrint print = geradorDeRelatorio.atribuiListaCarregadaNoRelatorio(funcionario.listar());
			// Visualiza relatorio no navegador com formato PDF
			geradorDeRelatorio.visualizarRelatorio(print,response);
		}
		
		// Exportar Relatorios
		/*String pdf = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.pdf";
		String xml = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.xml";
		String excel = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.xls";
		String csv = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.csv";
		String html = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.html";

		geradorDeRelatorio.exportarRelatorioNoFormatoHTML(print,html);
		geradorDeRelatorio.exportarRelatorioNoFormatoPDF(print,pdf);
		geradorDeRelatorio.exportarRelatorioNoFormatoXLS(print,excel);
		geradorDeRelatorio.exportarRelatorioNoFormatoCSV(print,csv);
		geradorDeRelatorio.exportarRelatorioNoFormatoXML(print,xml,false);*/
		
	}
	
	
}
