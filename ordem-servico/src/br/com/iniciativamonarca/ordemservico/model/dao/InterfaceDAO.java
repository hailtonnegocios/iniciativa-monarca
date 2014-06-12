package br.com.iniciativamonarca.ordemservico.model.dao;

import java.util.List;
import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo;

public interface InterfaceDAO <T> {
	
	void adicionar(T t);
	void alterar(T t);
	void salvar(T t) throws DAOException;
	void remover(Long id) throws DAOException;
	List<T> listar();
	T buscarPorId(Long id) throws DAOException;

}
