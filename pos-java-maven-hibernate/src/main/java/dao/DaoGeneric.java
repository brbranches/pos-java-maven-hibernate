package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.UsuarioPessoa;
import posjavamavenhibernate.HibernateUtil;

public class DaoGeneric<Entidade> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	/* Método de salvar genérico */
	public void salvar(Entidade entidade) {

		/*****
		 * tenho que chamar o getTransactrion e atribuito na var transaction
		 *******/
		EntityTransaction transaction = entityManager.getTransaction();

		/******** begin = iniciar a transação ********/
		transaction.begin();

		/********
		 * chamo o entityManager, que recebeu o getEntityManager, onde este recebeu o
		 * persistence que conecta com o banco. Feito isso, chama o persist e passa a
		 * entidade/objeto para persistir no banco
		 *******/
		entityManager.persist(entidade);

		/******** Comiit = salvar no banco ********/
		transaction.commit();
	}

	public Entidade pesquisar(Entidade entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);

		Entidade ent = (Entidade) entityManager.find(entidade.getClass(), id);
		return ent;
	}

	public Entidade pesquisar(Long id, Class<Entidade> entidade) {
		Entidade ent = (Entidade) entityManager.find(entidade, id);
		return ent;
	}

	public Entidade atualizar(Entidade entidade) {

		/*****
		 * tenho que chamar o getTransactrion e atribuito na var transaction
		 *******/
		EntityTransaction transaction = entityManager.getTransaction();

		/******** begin iniciar a transação ********/
		transaction.begin();

		/********
		 * chamo o entityManager, que recebeu o getEntityManager, onde este recebeu o
		 * persistence que conecta com o banco. Feito isso, chama o persist e passa a
		 * entidade/objeto para persistir no banco
		 *******/
		Entidade entidadeAtualizada = entityManager.merge(entidade);

		/******** Comiit = salvar no banco ********/
		transaction.commit();
		return entidadeAtualizada;
	}

	public void deletarPorId(Entidade entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager
				.createNativeQuery(
						"delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id)
				.executeUpdate(); // Faz delete

		transaction.commit();
	}

	public List<Entidade> buscarTodos(Class <Entidade> entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List <Entidade> listaUsuarios = entityManager.createQuery("from " + entidade.getName()).getResultList();	
		transaction.commit();

		return listaUsuarios;
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
}
