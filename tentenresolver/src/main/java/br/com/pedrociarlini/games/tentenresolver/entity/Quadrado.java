package br.com.pedrociarlini.games.tentenresolver.entity;

public class Quadrado {

	private Cor cor;

	private boolean preenchido;

	private int qtdParaSumir;

	public Quadrado() {
	}

	public Quadrado(Cor cor, boolean preenchido, int qtdParaSumir) {
		this();
		this.cor = cor;
		this.preenchido = preenchido;
		this.qtdParaSumir = qtdParaSumir;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public boolean isPreenchido() {
		return preenchido;
	}

	public void setPreenchido(boolean preenchido) {
		this.preenchido = preenchido;
	}

	public int getQtdParaSumir() {
		return qtdParaSumir;
	}

	public void setQtdParaSumir(int qtdParaSumir) {
		this.qtdParaSumir = qtdParaSumir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + (preenchido ? 1231 : 1237);
		result = prime * result + qtdParaSumir;
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
		Quadrado other = (Quadrado) obj;
		if (cor != other.cor)
			return false;
		if (preenchido != other.preenchido)
			return false;
		if (qtdParaSumir != other.qtdParaSumir)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quadrado [cor=" + cor + ", preenchido=" + preenchido + ", qtdParaSumir=" + qtdParaSumir + "]";
	}

}
