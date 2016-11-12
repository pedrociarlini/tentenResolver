package br.com.pedrociarlini.games.tentenresolver.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import br.com.pedrociarlini.games.tentenresolver.entity.Localizacao;
import br.com.pedrociarlini.games.tentenresolver.entity.Quadrado;

public class QuadradoUI extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Quadrado quadrado;

	private Localizacao localizacao;

	public QuadradoUI() {
	}

	public QuadradoUI(Localizacao loc, Quadrado quad) {
		setLocalizacao(loc);
		setQuadrado(quad);
	}

	@Override
	public void paint(Graphics g) {
		// super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		int tamanho = ConfiguracaoUI.TAMANHO;
		int gap = ConfiguracaoUI.ESPACO_ENTRE;
		int x = (tamanho + gap) * getLocalizacao().getLinha();
		int y = (tamanho + gap) * getLocalizacao().getColuna();

		setPreferredSize(new Dimension(tamanho, tamanho));
		if (getParent() != null && getParent() instanceof ArenaUI) {
			setBounds(x, y, tamanho, tamanho);
		}

		g2d.setColor(Color.DARK_GRAY);
		g2d.drawRoundRect(0, 0, tamanho, tamanho, 3, 3);
		g2d.setColor(ConfiguracaoUI.getColor(quadrado.getCor()));
		g2d.fillRect(1, 1, tamanho - 1, tamanho - 1);
	}

	public Quadrado getQuadrado() {
		return quadrado;
	}

	public void setQuadrado(Quadrado quadrado) {
		this.quadrado = quadrado;
		repaint();
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
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
		QuadradoUI other = (QuadradoUI) obj;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		return true;
	}
}
