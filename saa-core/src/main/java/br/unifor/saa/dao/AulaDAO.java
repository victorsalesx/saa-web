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

import br.unifor.saa.entity.Aula;
import br.unifor.saa.entity.Turma;
import br.unifor.saa.entity.Usuario;
/**
 * @author marcelorosa2@gmail.com
 * @since 28 de mar de 2016
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AulaDAO {

	@PersistenceContext
	private EntityManager em;

	private static final String ID_TURMA = "idTurma";
	private static final String ID_ALUNO = "idAluno";
	
	public void salvar(Aula aula) {
		em.persist(aula);
	}

	public void atualizar(Aula aula) {
		em.merge(aula);
	}
	@SuppressWarnings("unchecked")
	public List<Aula> listaAulaPorTurma(Turma turma) {
		String jpql = "from Aulas a where a.turma.id = :idTurma";
		Query query = em.createNamedQuery(jpql);
		query.setParameter(ID_TURMA, turma.getId());
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Aula>  listaAulaPorAluno(Usuario aluno) {
		String jpql = "from Aulas a where a.aluno.id = :idAluno";
		Query query = em.createQuery(jpql);
		query.setParameter(ID_ALUNO, aluno.getId());
		return query.getResultList();
	}
	
}