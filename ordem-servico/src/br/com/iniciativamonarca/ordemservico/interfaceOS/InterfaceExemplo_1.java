package br.com.iniciativamonarca.ordemservico.interfaceOS;

import java.util.List;

import br.com.iniciativamonarca.ordemservico.model.dao.DAOException;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo_1;

public interface InterfaceExemplo_1 {
	
	void adicionar(Exemplo_1 f);
	void alterar(Exemplo_1 f);
	void salvar(Exemplo_1 f) throws DAOException;
	void remover(Exemplo_1 f) throws DAOException;
	List<Exemplo_1> listar();
	Exemplo_1 buscarPorId(Long id) throws DAOException;

}
