package br.com.iniciativamonarca.ordemservico.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	
	public Boolean verificaFuncionario(String email) throws DAOException{
        boolean b;
		try {
			Query query = manager.createQuery(
					  "SELECT f FROM Funcionario f WHERE email = :email ");
					  query.setParameter("email",email);
				
			Funcionario func = (Funcionario)query.getSingleResult();
					
			b = func!= null ? true : false;
					  
			return b;
		} catch (NoResultException e) {
			return b = false;
		}

	}
	
	
	
	public List<Funcionario> listarLike(String campo, String valor) {
		Query query;
		try{
			if(!campo.equals("Todos")){
			   query = manager.createQuery("SELECT funcionario from Funcionario funcionario WHERE funcionario."+campo.trim()+" like'"+valor.trim()+"%' ");
			   return query.getResultList();
			}else{
				query = manager.createQuery("SELECT funcionario from Funcionario funcionario");
			    return query.getResultList();
		    } 
 	    }catch(NoResultException e){
		  System.out.println("Erro ao Consultar Funcionário");	   
		}
	    return null;
	}

	
	
	
}

