package br.com.iniciativamonarca.ordemservico.model.dao;

import java.util.List;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo;

public interface InterfaceExemplo {
	
	void adicionar(Exemplo f);
	void alterar(Exemplo f);
	void salvar(Exemplo f) throws DAOException;
	void remover(Exemplo f) throws DAOException;
	List<Exemplo> listar();
	Exemplo buscarPorId(Long id) throws DAOException;

}
