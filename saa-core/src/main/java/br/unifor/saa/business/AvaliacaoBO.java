/**
 * 
 */
package br.unifor.saa.business;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.saa.aspectj.PermitAll;
import br.unifor.saa.aspectj.RolesAllowed;
import br.unifor.saa.dao.AvaliacaoDAO;
import br.unifor.saa.entity.Avaliacao;
import br.unifor.saa.entity.Turma;
import br.unifor.saa.entity.Usuario;
import br.unifor.saa.exceptions.BOException;
import br.unifor.saa.util.MessagesResources;

/**
 * @author marcelorosa2@hotmail.com
 * @since  06 de abril de 2016
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AvaliacaoBO {

	@Inject
	private AvaliacaoDAO avaliacaoDAO;

	@PermitAll
	public List<Avaliacao> listaAvaliacaoPorTurma(Turma turma) {
		return avaliacaoDAO.listaAvaliacaoPorTurma(turma);
	}
	
	@PermitAll
	public List<Avaliacao> listaAvaliacaoPorAluno(Usuario aluno) {
		return avaliacaoDAO.listaAvaliacaoPorAluno(aluno);
	}

	// TODO verificar "CADASTRAR_AVALIACAO"
	@RolesAllowed("CADASTRAR_AVALIACAO")
	public void salvar(Avaliacao avaliacao) throws BOException {
		try {
			this.avaliacaoDAO.salvar(avaliacao);
		} catch (Exception e) {
			throw new BOException(MessagesResources.getMessages("cadAvaliacao.msg_salvar_error"));
		}
	}

}