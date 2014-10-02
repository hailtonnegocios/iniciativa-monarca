package br.com.iniciativamonarca.ordemservico.teste;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.ClassnameFilters;
import org.junit.runner.RunWith;

/**
 * Classe responsável por chamar todos as classes de teste do sistema. Todas as
 * classes que possuírem um @Test do Junit serão invocadas ao rodar essa classe.
 * É possível limitar isso utilizando {@link ClassnameFilters}
 */
@RunWith(ClasspathSuite.class)
public class OrdemServicoTestSuite {
	
	// Não faz nada
}