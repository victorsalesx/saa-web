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

import br.unifor.saa.entity.Avaliacao;
import br.unifor.saa.entity.Turma;
import br.unifor.saa.entity.Usuario;

/**
 * @author marcelorosa2@gmail.com
 * @since 06 de abril de 2016
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AvaliacaoDAO {

	@PersistenceContext
	private EntityManager em;

	private static final String ID_TURMA = "idTurma";
	private static final String ID_ALUNO = "idAluno";
	
	public void salvar(Avaliacao avaliacao) {
		em.persist(avaliacao);
	}

	public void atualizar(Avaliacao avaliacao) {
		em.merge(avaliacao);
	}
	@SuppressWarnings("unchecked")
	public List<Avaliacao> listaAvaliacaoPorTurma(Turma turma) {
		String jpql = "from Avaliacao av where av.turma.id = :idTurma";
		Query query = em.createNamedQuery(jpql);
		query.setParameter(ID_TURMA, turma.getId());
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Avaliacao>  listaAvaliacaoPorAluno(Usuario aluno) {
		String jpql = "select av from AVALIACOES av join av.alunos al where al.id = :idAluno";
		Query query = em.createQuery(jpql);
		query.setParameter(ID_ALUNO, aluno.getId());
		return query.getResultList();
	}
	
}

	
