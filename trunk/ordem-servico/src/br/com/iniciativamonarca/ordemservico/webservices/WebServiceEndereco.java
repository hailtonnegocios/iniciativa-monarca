package br.com.iniciativamonarca.ordemservico.webservices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.iniciativamonarca.ordemservico.model.entity.Endereco;

public class WebServiceEndereco {

	public static Endereco retornaEndereco(String cep) throws JAXBException,MalformedURLException {
		JAXBContext jc = JAXBContext.newInstance(Endereco.class);

		Unmarshaller u = jc.createUnmarshaller();
		URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep="+ cep +"&formato=xml");
		Endereco wCep = (Endereco) u.unmarshal(url);

		return wCep;
	}
}
