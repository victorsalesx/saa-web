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
import br.unifor.saa.dao.FuncionalidadeDAO;
import br.unifor.saa.entity.Funcionalidade;
import br.unifor.saa.entity.Usuario;

/**
 * @author marcelorosa2@hotmail.com
 * @since  06 de abril de 2016
 */

//TODO Incompleto

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FuncionalidadeBO {

	@Inject
	private FuncionalidadeDAO funcionalidadeDAO;

	@PermitAll
	public List<Funcionalidade> listaFuncionalidadePorUsuario(Usuario usuario) {
		return funcionalidadeDAO.listaFuncionalidadePorUsuario(usuario);
	}
	
}
