package br.com.iniciativamonarca.ordemservico.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.dao.InterfaceDAO;
import br.com.iniciativamonarca.ordemservico.model.entity.Cliente;

@Repository
public class ClienteDAO implements InterfaceDAO <Cliente>{

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void adicionar(Cliente c) {
		manager.persist(c);
		
	}

	@Override
	public void alterar(Cliente c) {
		manager.merge(c);
		
	}

	@Override
	public void salvar(Cliente c) throws DAOException {
		try {
			if (c.getId_cliente() == null || c.getId_cliente().equals("")) {
				manager.persist(c);
			} else
				manager.merge(c);
		} catch (Exception e) {
			throw new DAOException("Erro ao gravar Cliente !");
		}
		
	}

	@Override
	public void remover(Long id) throws DAOException {
		try {
			Cliente clienteRemover = buscarPorId(id);
			manager.remove(clienteRemover);
		} catch (Exception e) {
			throw new DAOException("Erro ao remover o cliente !");
		}
	}

	
	@Override
	public List listar() {
		return manager.createQuery("SELECT c from Cliente c")
				.getResultList();
	}

	@Override
	public Cliente buscarPorId(Long id) throws DAOException {
		try {
			return manager.find(Cliente.class, id);
		} catch (Exception e) {
			throw new DAOException("Cliente não encontrado !");
		}
	}

}
