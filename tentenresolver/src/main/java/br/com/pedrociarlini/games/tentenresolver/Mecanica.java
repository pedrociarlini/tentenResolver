package br.com.pedrociarlini.games.tentenresolver;

import java.util.ArrayList;
import java.util.List;

import br.com.pedrociarlini.games.tentenresolver.business.RegrasImplementation;
import br.com.pedrociarlini.games.tentenresolver.entity.Localizacao;
import br.com.pedrociarlini.games.tentenresolver.entity.Peca;
import br.com.pedrociarlini.games.tentenresolver.ui.JanelaPrincipal;

public class Mecanica {
	public static final String ACAO_ADD_PECA_RANDOM = "ACAO_ADD_PECA_RANDOM";

	private Ambiente ambiente = new Ambiente();

	private RegrasImplementation regras = new RegrasImplementation();

	JanelaPrincipal janela;

	private boolean gameOver = false;

	public Mecanica() {
		janela = new JanelaPrincipal(this);
		janela.setVisible(true);
		if (Jogo.isEmDebug()) {
			// checarPecas();
		}
		iniciarTurno();
	}

	public void pausa() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.err.println("Erro durante a pausa: " + e.getMessage());
		}
	}

	private void iniciarTurno() {
		ambiente.oferecerPecas(geraPecas());
		if (Jogo.isEmDebug()) {
			System.out.println(ambiente.getPecasDisponiveis());
		}
	}

	public void adicionarPeca(int linha, int coluna, Peca peca) {
		ambiente.adicionarPeca(linha, coluna, peca);
		if (ambiente.containsPecaDisponivel(peca)) {
			ambiente.removerPecaDisponivel(peca);
			if (ambiente.getPecasDisponiveisSize() == 0) {
				iniciarTurno();
			}
		}
		// efetuaDesaparecimento(linha, coluna, peca);
		if (!ambiente.disponiveisTemChance()) {
			gameOver = true;
			System.out.println("GAME OVER");
		}
	}

	private void efetuaDesaparecimento(int linha, int coluna, Peca peca) {
		boolean linhaTemBuraco;
		boolean colunaTemBuraco;
		for (int i = 1; i <= 10; i++) {
			linhaTemBuraco = false;
			colunaTemBuraco = false;
			for (int j = 1; j < 10; j++) {
				// Checando linha
				if (ambiente.getArena().containsKey(new Localizacao(i, j))) {
					linhaTemBuraco = true;
				}
				// Checando linha
				if (ambiente.getArena().containsKey(new Localizacao(j, i))) {
					linhaTemBuraco = true;
				}
			}
			if (!linhaTemBuraco) {
				ambiente.limpaLinha(i);
			}
			if (!colunaTemBuraco) {
				ambiente.limpaColuna(i);
			}
		}
	}

	public void adicionarPeca(int linha, int coluna, int numPeca) {
		if (RegrasImplementation.getPecas().containsKey(numPeca)) {
			adicionarPeca(linha, coluna, RegrasImplementation.getPecas().get(numPeca));
		}
	}

	private List<Peca> geraPecas() {
		ArrayList<Peca> result = new ArrayList<Peca>();
		for (int i = 0; i < regras.getNumNovasPecas(); i++) {
			result.add(regras.getPecaAleatoria());
		}
		return result;
	}

	private void limparPecas() {
		ambiente.limparArena();
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
