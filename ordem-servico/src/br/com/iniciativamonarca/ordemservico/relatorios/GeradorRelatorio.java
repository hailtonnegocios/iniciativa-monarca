package br.com.iniciativamonarca.ordemservico.relatorios;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;


public class GeradorRelatorio {
	
	String nome;
	Map<String, Object> parameters;
	Connection connection;
	
	
	
	
	public GeradorRelatorio(String nome, Map<String, Object> parameters,
			Connection connection) {
		super();
		this.nome = nome;
		this.parameters = parameters;
		this.connection = connection;
	}




	public void geraPDF(OutputStream output) throws JRException, FileNotFoundException {
		JasperPrint print = JasperFillManager.fillReport(nome, parameters , connection);
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
		exporter.exportReport();
	}
}
