package br.com.iniciativamonarca.ordemservico.relatorios;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

public class GeradorRelatorio {

	HttpServletRequest request;
	HttpServletResponse response;
	Map<String, Object> parameters;
	String nome_arquivo;

	public GeradorRelatorio(String nome_arquivo, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> parameters) {
		super();
		this.parameters = parameters;
		this.request = request;
		this.response = response;
		this.nome_arquivo = nome_arquivo;
	}

	public JasperReport retornaArquivoCompilado(HttpServletRequest request) {
		try {
			// Compila o arquivo JRXML
			JasperReport report = JasperCompileManager.compileReport(request
					.getServletContext().getRealPath(
							"/WEB-INF/relatorios/" + nome_arquivo));
			return report;
		} catch (JRException e) {
			System.out.println("Erro ao compilar arquivo");
			e.printStackTrace();
			return null;
		}
	}

	// Passagem da lista para o relatório
	public JasperPrint atribuiListaCarregadaNoRelatorio(List<?> lista) {
		try {
			JasperPrint print = JasperFillManager.fillReport(
					retornaArquivoCompilado(request), parameters,
					new JRBeanCollectionDataSource(lista));
			return print;
		} catch (JRException e) {
			System.out.println("Erro ao colocar a lista no relatório");
			e.printStackTrace();
			return null;
		}
	}

	public void visualizarRelatorio(JasperPrint print,
			HttpServletResponse response) {
		try {
			JasperExportManager.exportReportToPdfStream(print,response.getOutputStream());
			System.out.println("Relatório gerado.");
		} catch (JRException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro ao gerar relatorio.");
		}
	}

	public void exportarRelatorioNoFormatoHTML(JasperPrint print, String destino) {
		try {
			JasperExportManager.exportReportToHtmlFile(print, destino);
			System.out.println("Relatório HTML exportado.");
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Erro ao exportar relatorio em HTML");
		}
	}

	public void exportarRelatorioNoFormatoPDF(JasperPrint print, String destino) {
		try {
			JasperExportManager.exportReportToPdfFile(print, destino);
			System.out.println("Relatório PDF exportado.");
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Erro ao exportar relatorio em PDF");
		}
	}

	public void exportarRelatorioNoFormatoXML(JasperPrint print,
			String destino, Boolean possuiFoto) {
		try {
			JasperExportManager.exportReportToXmlFile(print, destino,possuiFoto);
			System.out.println("Relatório XML exportado.");
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Erro ao exportar relatorio em XML");
		}
	}

	public void exportarRelatorioNoFormatoXLS(JasperPrint print, String destino) {
		try {
			JRXlsExporter exporterXLS = new JRXlsExporter();
			exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,destino);
			/*exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);*/
			exporterXLS.exportReport();
			System.out.println("Relatório XLS exportado.");
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Erro ao exportar relatorio em XLS");
		}
	}

	public void exportarRelatorioNoFormatoCSV(JasperPrint print, String destino) {
		try {
			JRCsvExporter exporterCsv = new JRCsvExporter();
			exporterCsv.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporterCsv.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,destino);
			exporterCsv.exportReport();
			System.out.println("Relatório CSV exportado.");
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Erro ao exportar relatorio em CSV");
		}
	}

}
