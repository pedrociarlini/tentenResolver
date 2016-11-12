package br.com.pedrociarlini.games.tentenresolver.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Peca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Localizacao, Quadrado> formato = new HashMap<Localizacao, Quadrado>();

	public Map<Localizacao, Quadrado> getFormato() {
		return formato;
	}

	public void setFormato(Map<Localizacao, Quadrado> formato) {
		this.formato = formato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getFormato() == null) ? 0 : getFormato().hashCode());
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
		Peca other = (Peca) obj;
		if (getFormato() == null) {
			if (other.getFormato() != null)
				return false;
		} else if (!getFormato().equals(other.getFormato()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String result = "";
		int maxL = 0, maxCol = 0;
		for (Localizacao loc : formato.keySet()) {
			maxL = (loc.getLinha() > maxL) ? loc.getLinha() : maxL;
			maxCol = (loc.getColuna() > maxCol) ? loc.getColuna() : maxCol;
		}
		for (int linha = 1; linha <= maxL; linha++) {
			for (int col = 1; col <= maxCol; col++) {
				if (formato.containsKey(new Localizacao(linha, col))) {
					result += "[*]";
				} else {
					result += "[ ]";
				}
			}
			result += "\n";
		}

		return result;
	}
}