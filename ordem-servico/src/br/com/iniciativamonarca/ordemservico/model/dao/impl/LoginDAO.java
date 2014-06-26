package br.com.iniciativamonarca.ordemservico.model.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.iniciativamonarca.ordemservico.criptografia.Criptografia;
import br.com.iniciativamonarca.ordemservico.exceptions.DAOException;
import br.com.iniciativamonarca.ordemservico.model.entity.Funcionario;

@Repository
public class LoginDAO  {

	@PersistenceContext
	EntityManager manager;


	public Funcionario efetuarLogin(Funcionario funcionario)
			throws DAOException {
		try {
			Query query = manager.createQuery(
					  "SELECT f FROM Funcionario f WHERE email = :email AND senha = :senha");
					  query.setParameter("email", funcionario.getEmail());
					  query.setParameter("senha", Criptografia.encriptarSenha(funcionario.getSenha(),"MD5"));
					  
					  Funcionario func = (Funcionario) query.getSingleResult();
			return func;
		} catch (Exception r) {
			throw new DAOException("Erro ao validar Usuario !");
		}

	}

}
