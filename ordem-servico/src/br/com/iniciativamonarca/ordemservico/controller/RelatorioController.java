package br.com.iniciativamonarca.ordemservico.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iniciativamonarca.ordemservico.model.dao.impl.FuncionarioDAO;
import br.com.iniciativamonarca.ordemservico.relatorios.GeradorRelatorio;


@Controller
public class RelatorioController {

	@Autowired
	FuncionarioDAO funcionario ;
	
	
	@RequestMapping("relatorioTeste")
	public void geraRelatorio(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, JRException, IOException{
		Map<String, Object> parameters = new HashMap<String, Object>();


		GeradorRelatorio geradorDeRelatorio = new GeradorRelatorio("usuarios.jrxml",request,response,parameters);
		// Carrega lista no Relatorio para dar o Print
		JasperPrint print = geradorDeRelatorio.atribuiListaCarregadaNoRelatorio(funcionario.listar());
		// Visualiza relatorio no navegador com formato PDF
		geradorDeRelatorio.visualizarRelatorio(print,response);
		
		// Exportar Relatorios
		String pdf = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.pdf";
		String xml = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.xml";
		String excel = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.xls";
		String csv = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.csv";
		String html = "C:/Users/Hailton/Desktop/Tela_Funcionario/Funcionarios.html";

		geradorDeRelatorio.exportarRelatorioNoFormatoHTML(print,html);
		geradorDeRelatorio.exportarRelatorioNoFormatoPDF(print,pdf);
		geradorDeRelatorio.exportarRelatorioNoFormatoXLS(print,excel);
		geradorDeRelatorio.exportarRelatorioNoFormatoCSV(print,csv);
		geradorDeRelatorio.exportarRelatorioNoFormatoXML(print,xml,false);
		
	}
	
	
}
