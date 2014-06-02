package br.com.iniciativa21.ordemservico.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import br.com.iniciativa21.ordemservico.interfaceOS.InterfaceFuncionario;
import br.com.iniciativa21.ordemservico.model.entity.Funcionario;

@Repository
public class FuncionarioDAO implements InterfaceFuncionario {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void salvar(@Valid Funcionario f) throws DAOException {
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
	public void adicionar(Funcionario f) {
		manager.persist(f);
	}

	@Override
	public void alterar(Funcionario f) {
		manager.merge(f);
	}

	@Override
	public void remover(Funcionario f) throws DAOException {
		try {
			Funcionario funcRemover = buscarPorId(f.getId_usuario());
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

	public List<Funcionario> efetuarLogin(Funcionario funcionario)
			throws DAOException {
		try {
			TypedQuery<Funcionario> query = manager.createQuery(
					"SELECT f FROM Funcionario f " + "WHERE f.email = :email  "
							+ " AND f.senha  = :senha ", Funcionario.class);

			query.setParameter("email", funcionario.getEmail().toString());
			query.setParameter("senha", funcionario.getSenha().toString());
			List<Funcionario> u = query.getResultList();

			return u;

		} catch (Exception r) {
			// throw new
			// DAOException("Erro de SQL ao validar Usuario !!! : "+r);
			throw new DAOException("Erro ao validar Usuario !");
		}

	}

}
