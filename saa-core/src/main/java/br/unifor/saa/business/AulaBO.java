/**
 * 
 */
package br.unifor.saa.business;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.saa.aspectj.RolesAllowed;
import br.unifor.saa.dao.AulaDAO;
import br.unifor.saa.dao.TurmaDAO;
import br.unifor.saa.entity.Aula;
import br.unifor.saa.entity.Turma;
import br.unifor.saa.entity.Usuario;

/**
 * @author marcelorosa2@hotmail.com
 * @since  06 de abril de 2016
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AulaBO {

	@Inject
	private AulaDAO aulaDAO;

//	@PermitAll
	@RolesAllowed("LISTA_AULA")
	public List<Aula> listaAulaPorTurma(Turma turma) {
		return aulaDAO.listaAulaPorTurma(turma);
	}
	
	@RolesAllowed("LISTA_AULA")
	public List<Aula> listaAulaPorAluno(Usuario aluno) {
		return aulaDAO.listaAulaPorAluno(aluno);
	}

//	// TODO verificar "CADASTRAR_AULA"
//	@RolesAllowed("CADASTRAR_AULA")
//	public void salvar(Aula aula) throws BOException {
//		try {
//			this.aulaDAO.salvar(aula);
//		} catch (Exception e) {
//			throw new BOException(MessagesResources.getMessages("cadAula.msg_salvar_error"));
//		}
//	}

}

