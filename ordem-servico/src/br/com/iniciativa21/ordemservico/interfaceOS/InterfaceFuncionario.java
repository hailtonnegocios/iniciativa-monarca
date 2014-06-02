package br.com.iniciativa21.ordemservico.interfaceOS;

import java.util.List;

import br.com.iniciativa21.ordemservico.model.dao.DAOException;
import br.com.iniciativa21.ordemservico.model.entity.Funcionario;

public interface InterfaceFuncionario {
	
	void adicionar(Funcionario f);
	void alterar(Funcionario f);
	void salvar(Funcionario f) throws DAOException;
	void remover(Funcionario f)throws DAOException;
	List<Funcionario> listar();
	Funcionario buscarPorId(Long id)throws DAOException;

}
