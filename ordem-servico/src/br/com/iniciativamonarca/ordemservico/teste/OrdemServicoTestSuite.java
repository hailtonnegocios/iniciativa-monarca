package br.com.iniciativamonarca.ordemservico.teste;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.ClassnameFilters;
import org.junit.runner.RunWith;

/**
 * Classe respons�vel por chamar todos as classes de teste do sistema. Todas as
 * classes que possu�rem um @Test do Junit ser�o invocadas ao rodar essa classe.
 * � poss�vel limitar isso utilizando {@link ClassnameFilters}
 */
@RunWith(ClasspathSuite.class)
public class OrdemServicoTestSuite {
	
	// N�o faz nada
}