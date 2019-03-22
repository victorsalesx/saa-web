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

import br.unifor.saa.entity.Funcionalidade;
import br.unifor.saa.entity.Usuario;

/**
 * @author marcelorosa2@gmail.com
 * @since 06 de abril de 2016
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class FuncionalidadeDAO {

	@PersistenceContext
	private EntityManager em;

	private static final String ID_USUARIO = "idUsuario";
	
	public void salvar(Funcionalidade funcionalidade) {
		em.persist(funcionalidade);
	}

	public void atualizar(Funcionalidade funcionalidade) {
		em.merge(funcionalidade);
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionalidade>  listaFuncionalidadePorUsuario(Usuario usuario) {
		String jpql = "select f from Funcionalidades f join f.usuarios al where al.id = :idUsuario";
		Query query = em.createQuery(jpql);
		query.setParameter(ID_USUARIO, usuario.getId());
		return query.getResultList();
	}

	
}
