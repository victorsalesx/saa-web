package br.unifor.saa.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 * @author patrick.cunha
 * 
 */
public class MessagesUtils {

	public static void info(String msg) {
		System.out.println(msg);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info:", msg));
	}
	
	public static void warn(String msg) {
		System.out.println(msg);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção:", msg));
	}
	
	public static void error(String msg) {
		System.out.println(msg);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", msg));
	}
	
	public static void fatal(String msg) {
		System.out.println(msg);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, "Crash:", msg));
	}

}
