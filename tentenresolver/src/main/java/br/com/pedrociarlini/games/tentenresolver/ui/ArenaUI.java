package br.com.pedrociarlini.games.tentenresolver.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import br.com.pedrociarlini.games.tentenresolver.ui.exception.ComponenteInvalidoException;

public class ArenaUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean gameOver;

	public ArenaUI() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(300, 600));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tamanho = ConfiguracaoUI.TAMANHO, gap = ConfiguracaoUI.ESPACO_ENTRE;
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				g2d.setColor(ConfiguracaoUI.COR_VAIZO);
				g2d.fillRoundRect((tamanho + gap) * i, (tamanho + gap) * j, tamanho, tamanho, 3, 3);
			}
		}
		if (gameOver) {
			g2d.setFont(new Font("Verdana", Font.BOLD, 24));
			g2d.setColor(Color.WHITE);
			g2d.drawString("GAME OVER", getWidth() / 2 - 30, getHeight() - 24);
		}
	}

	/**
	 * Essa arena só aceita componentes do tipo do Jogo.
	 */
	@Override
	protected void addImpl(Component comp, Object constraints, int index) {
		if (comp instanceof QuadradoUI) {
			super.addImpl(comp, constraints, index);
		} else {
			throw new ComponenteInvalidoException("Insira apenas objetos filhos de " + QuadradoUI.class);
		}
	}

	public void setGameOver(boolean b) {
		this.gameOver = b;
	}
}
