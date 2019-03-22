/**
 * 
 */
package br.unifor.saa.business;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.saa.aspectj.PermitAll;
import br.unifor.saa.dao.PapelDAO;
import br.unifor.saa.entity.Papel;
import br.unifor.saa.exceptions.BOException;

/**
 *  @author marcelorosa2@hotmail.com
 * @since  06 de abril de 2016
 */

//TODO implementar tudo!!!!!
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class PapelBO {

	@Inject
	private PapelDAO papelDAO;

	@PermitAll
	public void salvar(Papel papel) throws BOException {
	}
	
}