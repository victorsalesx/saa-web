package br.unifor.saa.manager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import br.unifor.saa.business.TurmaBO;
import br.unifor.saa.entity.Turma;
import br.unifor.saa.to.SegurancaTO;
import br.unifor.saa.utils.Navigation;

@RequestScoped
@Scope("session")
@Named(value = "listaTurmaManager")
@ManagedBean(name = "listaTurmaManager")
public class ListaTurmaMB {
	
	@Inject
	private TurmaBO turmaBO;
	@Inject
	private SegurancaTO segurancaTO;
	
	private List<Turma> turmas;
	
	public String preparaListTurma(){
		turmas = turmaBO.listaTurmaPorProfessor(segurancaTO.getUsuario());
		return Navigation.SUCESSO;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

}
