package br.com.iniciativamonarca.ordemservico.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.InterfaceExemplo_1;
import br.com.iniciativamonarca.ordemservico.model.entity.Exemplo_1;

@Repository
public class Exemplo_1DAOImpl implements InterfaceExemplo_1{
	
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public void salvar(@Valid Exemplo_1 exe) throws DAOException {
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
	public void adicionar(Exemplo_1 exe) {
		manager.persist(exe);
	}

	@Override
	public void alterar(Exemplo_1 exe) {
		manager.merge(exe);
	}

	@Override
	public void remover(Exemplo_1 exe) throws DAOException {
		try {
			Exemplo_1 exeRemover = buscarPorId(exe.getId_exemplo());
			manager.remove(exeRemover);
		} catch (Exception e) {
			throw new DAOException("Erro ao remover Exemplo_1");
		}

	}

	@Override
	public List<Exemplo_1> listar() {
		return manager.createQuery("SELECT exe from Exemplo_1 exe")
				.getResultList();
	}

	@Override
	public Exemplo_1 buscarPorId(Long id) throws DAOException {
		try {
			return manager.find(Exemplo_1.class, id);
		} catch (Exception e) {
			throw new DAOException("Exemplo_1 não encontrado !");
		}
	}



}
