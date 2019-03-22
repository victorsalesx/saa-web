/**
 * 
 */
package br.unifor.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.saa.entity.Papel;
import br.unifor.saa.entity.Usuario;

/**
 * @author marcelorosa2@gmail.com
 * @since 06 de abril de 2016
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PapelDAO {

	@PersistenceContext
	private EntityManager em;

	private static final String ID_USUARIO = "idUsuario";

	public void salvar(Papel papel) {
		em.persist(papel);
	}

	public void atualizar(Papel papel) {
		em.merge(papel);
	}


	@SuppressWarnings("unchecked")
	public List<Papel> listaPapelPorUsuario(Usuario usuario) {
		String jpql = "select p from Papeis p join p.usuarios a where a.id = :idUsuario";
		Query query = em.createQuery(jpql);
		query.setParameter(ID_USUARIO , usuario.getId());
		return query.getResultList();
	}

}