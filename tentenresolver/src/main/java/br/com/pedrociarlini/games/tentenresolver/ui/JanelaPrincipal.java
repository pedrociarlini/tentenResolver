package br.com.pedrociarlini.games.tentenresolver.ui;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.pedrociarlini.games.tentenresolver.AmbienteListener;
import br.com.pedrociarlini.games.tentenresolver.Mecanica;
import br.com.pedrociarlini.games.tentenresolver.entity.Localizacao;
import br.com.pedrociarlini.games.tentenresolver.entity.Peca;
import br.com.pedrociarlini.games.tentenresolver.entity.Quadrado;

public class JanelaPrincipal extends JFrame implements AmbienteListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPane;
	private ArenaUI arenaUi;
	private AreaPecasUI areaPecasUI;
	private Mecanica mecanica;

	public JanelaPrincipal(Mecanica m) {
		this.mecanica = m;
		m.getAmbiente().addAmbienteListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 750);
		setResizable(true);
		setTitle("TenTen Inteligente");
		setContentPane(getMainPane());
	}

	private JPanel getMainPane() {
		if (mainPane == null) {
			mainPane = new JPanel();
			mainPane.setLayout(new BorderLayout(2, 2));
			mainPane.add(getArena(), BorderLayout.CENTER);
			mainPane.add(getAreaPecas(), BorderLayout.SOUTH);
		}
		return mainPane;
	}

	private AreaPecasUI getAreaPecas() {
		if (areaPecasUI == null) {
			areaPecasUI = new AreaPecasUI(mecanica);
		}
		return areaPecasUI;
	}

	public ArenaUI getArena() {
		if (arenaUi == null) {
			arenaUi = new ArenaUI();
		}
		return arenaUi;
	}

	public void adcionarPeca(Map<Localizacao, Quadrado> quadrados) {
		if (quadrados != null) {
			QuadradoUI comp;
			for (Localizacao loc : quadrados.keySet()) {
				comp = new QuadradoUI(loc, quadrados.get(loc));
				getArena().remove(comp);
				getArena().add(comp);
			}
			validate();
		}
	}

	public void limparQuadrados() {
		getArena().removeAll();
		getArena().repaint();
		validate();
	}

	public void oferecePecas(List<Peca> pecasDisponiveis) {
	}

	/**
	 * Disparado quando algo acontece a Arena.
	 */
	public void ambienteAlterado(Evento evt) {
		if (evt.getTipo() == TipoEvento.PECA_ADICIONADA) {
			adcionarPeca(evt.getQuadrados());
		} else if (evt.getTipo() == TipoEvento.ARENA_LIMPA) {
			limparQuadrados();
		} else if (evt.getTipo() == TipoEvento.GAME_OVER) {
			getArena().setGameOver(true);
			repaint();
			validate();
		} else if (evt.getTipo() == TipoEvento.QUADRADOS_SUMIRAM) {
			for (Localizacao loc : evt.getQuadrados().keySet()) {
				getArena().remove(new QuadradoUI(loc, null));
			}
		}

	}
}
