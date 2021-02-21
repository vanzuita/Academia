package br.com.academia.controller;

import java.util.List;

public interface DAO<T> {

	public void incluir(T obj);
	public void alterar(T obj);
	public void excluir(int id);
	public T pesquisar(int id);
	public List<T> pesquisar();
}
