package br.com.pedrociarlini.games.tentenresolver.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.pedrociarlini.games.tentenresolver.Mecanica;
import br.com.pedrociarlini.games.tentenresolver.business.RegrasImplementation;

public class AreaPecasUI extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addButton;
	private Mecanica mecanica;
	private JPanel panelBotoes;
	private JPanel panelNovasPecas;

	public AreaPecasUI(Mecanica m) {
		this.mecanica = m;
		setLayout(new BorderLayout(5, 5));
		add(getPanelNovasPecas(), BorderLayout.CENTER);
		add(getPanelBotoes(), BorderLayout.SOUTH);
	}

	public JPanel getPanelNovasPecas() {
		if (panelNovasPecas == null) {
			panelNovasPecas = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
			panelNovasPecas.setPreferredSize(new Dimension(300, 300));
		}
		return panelNovasPecas;
	}

	private JPanel getPanelBotoes() {
		if (panelBotoes == null) {
			panelBotoes = new JPanel();
			panelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
			panelBotoes.add(getAddButon());
		}
		return panelBotoes;
	}

	private JButton getAddButon() {
		if (addButton == null) {
			addButton = new JButton("Adicionar peça");
			addButton.addActionListener(this);
			addButton.setActionCommand(Mecanica.ACAO_ADD_PECA_RANDOM);
		}
		return addButton;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == Mecanica.ACAO_ADD_PECA_RANDOM) {
			Random r = new Random();

			mecanica.adicionarPeca(r.nextInt(9) + 1, r.nextInt(9) + 1,
					new Random().nextInt(RegrasImplementation.getPecas().size()));
		}
	}
}
