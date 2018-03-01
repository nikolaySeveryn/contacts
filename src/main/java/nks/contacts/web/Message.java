package nks.contacts.web;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Message {
	
	public static Message errorMessge(String details){
		return new Message(FacesMessage.SEVERITY_ERROR, "Error", details);
	}
	public static Message infoMessage(String title, String details){
		return new Message(FacesMessage.SEVERITY_INFO, title, details);
	}
	
	
	private final FacesMessage.Severity severity;
	private final String title;
	private final String details;
	
	
	public Message(Severity severity, String title, String details) {
		this.severity = severity;
		this.title = title;
		this.details = details;
	}
	
	
	public void show() {
		FacesMessage msg = new FacesMessage(severity, title, details);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
