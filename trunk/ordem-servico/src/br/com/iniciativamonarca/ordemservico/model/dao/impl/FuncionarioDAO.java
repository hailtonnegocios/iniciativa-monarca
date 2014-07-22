package br.com.iniciativamonarca.ordemservico.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.InterfaceDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;

@Repository
public class FuncionarioDAO implements InterfaceDAO<Funcionario>{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void salvar(Funcionario f) throws DAOException {
		try {
			if (f.getId_usuario() == null || f.getId_usuario().equals("")) {
				manager.persist(f);
			} else
				manager.merge(f);
		} catch (Exception e) {
			throw new DAOException("Erro ao gravar Funcionario!");
		}
	}

	@Override
	public void adicionar(@Valid Funcionario f) {
		manager.persist(f);
	}

	@Override
	public void alterar(Funcionario f) {
		manager.merge(f);
	}

	@Override
	public void remover(Long id) throws DAOException {
		try {
			Funcionario funcRemover = buscarPorId(id);
			manager.remove(funcRemover);
		} catch (Exception e) {
			throw new DAOException("Erro ao remover funcionario");
		}

	}

	@Override
	public List<Funcionario> listar() {
		return manager.createQuery("SELECT f from Funcionario f")
				.getResultList();
	}

	@Override
	public Funcionario buscarPorId(Long id) throws DAOException {
		try {
			return manager.find(Funcionario.class, id);
		} catch (Exception e) {
			throw new DAOException("Funcionario não encontrado !");
		}
	}

	
	
}

