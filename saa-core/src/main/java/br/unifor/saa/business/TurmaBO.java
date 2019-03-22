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
import br.unifor.saa.dao.TurmaDAO;
import br.unifor.saa.entity.Turma;
import br.unifor.saa.entity.Usuario;

/**
 * @author adrianopatrick@gmail.com
 * @since 16 de mar de 2016
 */
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class TurmaBO {

	@Inject
	private TurmaDAO turmaDAO;
	
	@RolesAllowed("LISTA_TURMA")
	public List<Turma> listaTurmaPorProfessor(Usuario professor){
		return turmaDAO.listaTurmaPorProfessor(professor);
	}

}
