package br.unitins.books.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexController {

	private String login = "";
	private String senha;

	public String entrar() {
		if (login.equals("joao") && senha.equals("123")) {
			// redirect
			return "hello.xhtml?page2?faces-redirect=true";

		}
		// if it goes wrongs, send message
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou(e) Senha incorreto(s)", null));
		return null;
	}

	public void limpar() {
		setLogin("");
		setSenha("");
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
