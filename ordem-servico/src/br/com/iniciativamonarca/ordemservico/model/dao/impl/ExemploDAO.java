package br.com.iniciativamonarca.ordemservico.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.InterfaceDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo;

@Repository
public class ExemploDAO implements InterfaceDAO<Exemplo>{
	
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public void salvar(@Valid Exemplo exe) throws DAOException {
		try {
			if (exe.getId_exemplo() == null || exe.getId_exemplo().equals("")) {
				manager.persist(exe);
			} else
				manager.merge(exe);
		} catch (Exception e) {
			throw new DAOException("Erro ao gravar Exemplo_1!");
		}
	}

	@Override
	public void adicionar(Exemplo exe) {
		manager.persist(exe);
	}

	@Override
	public void alterar(Exemplo exe) {
		manager.merge(exe);
	}

	@Override
	public void remover(Long id) throws DAOException {
		try {
			Exemplo exeRemover = buscarPorId(id);
			manager.remove(exeRemover);
		} catch (Exception e) {
			throw new DAOException("Erro ao remover Exemplo_1");
		}

	}

	@Override
	public List<Exemplo> listar() {
		return manager.createQuery("SELECT exe from Exemplo exe")
				.getResultList();
	}

	@Override
	public Exemplo buscarPorId(Long id) throws DAOException {
		try {
			return manager.find(Exemplo.class, id);
		} catch (Exception e) {
			throw new DAOException("Exemplo_1 não encontrado !");
		}
	}



}
