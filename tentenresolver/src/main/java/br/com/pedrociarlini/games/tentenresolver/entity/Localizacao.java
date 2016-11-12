package br.com.pedrociarlini.games.tentenresolver.entity;

import java.io.Serializable;

public class Localizacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int linha;

	private int coluna;

	public Localizacao() {
	}

	public Localizacao(int linha, int coluna) {
		this();
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coluna;
		result = prime * result + linha;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localizacao other = (Localizacao) obj;
		if (coluna != other.coluna)
			return false;
		if (linha != other.linha)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Localizacao [linha=" + linha + ", coluna=" + coluna + "]";
	}
}
