package br.com.persistencia.interfaces;

import java.util.List;

import br.com.modelo.Cliente;

public interface ClienteGerenciable {

	public void guardar(Cliente cliente);

	public List<Cliente> consultarTodosDAO();
	
}
