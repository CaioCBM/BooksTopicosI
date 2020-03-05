package br.unitins.books.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.books.application.Util;
import br.unitins.books.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -363556965312364462L;

	private Usuario usuario;
	private List<Usuario> listaUsuario;

	public void cadastrar() {
		if (getUsuario().getNome().isBlank()) {
			Util.addErrorMessage("O campo 'nome' deve ser informado!");
			return;
		}
		getUsuario().setId(proximoId());
		getListaUsuario().add(getUsuario());
		limpar();

	}

	public void alterar() {
		getUsuario().setId(proximoId());
		// Obtendo o indice da referencia da lista
		int index = listaUsuario.indexOf(getUsuario());
		// subtituindo o objeto da lista pelo indice

		listaUsuario.set(index, getUsuario());
		limpar();
	}

	public void remover() {
		getListaUsuario().remove(getUsuario());
		limpar();
	}

	public void editar(Usuario user) {
		setUsuario(user.getClone());
	}

	public void limpar() {
		usuario = null;
	}

	private int proximoId() {
		int resultado = 0;
		for (Usuario usuario : listaUsuario) {
			if (usuario.getId() > resultado)
				resultado = usuario.getId();
		}
		return ++resultado;

	}

	// GET E SET

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null)
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}

}
