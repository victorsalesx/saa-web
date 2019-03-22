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

import br.unifor.saa.entity.Turma;
import br.unifor.saa.entity.Usuario;

/**
 * @author adrianopatrick@gmail.com
 * @since 16 de mar de 2016
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class TurmaDAO {

	@PersistenceContext
	private EntityManager em;
	
	private static final String ID_PROFESSOR="idProfessor";
	

	public void salvar(Turma turma) {
		em.persist(turma);
	}

	public void atualizar(Turma turma) {
		em.merge(turma);
	}

	@SuppressWarnings("unchecked")
	public List<Turma> listaTurmaPorProfessor(Usuario professor) {
		String jpql = "from Turma t where t.professor.id = :idProfessor";
		Query query = em.createNamedQuery(jpql);
		query.setParameter(ID_PROFESSOR, professor.getId());
		return query.getResultList();
	}

}
