package br.com.pedrociarlini.games.tentenresolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.pedrociarlini.games.tentenresolver.AmbienteListener.Evento;
import br.com.pedrociarlini.games.tentenresolver.AmbienteListener.TipoEvento;
import br.com.pedrociarlini.games.tentenresolver.entity.Localizacao;
import br.com.pedrociarlini.games.tentenresolver.entity.Peca;
import br.com.pedrociarlini.games.tentenresolver.entity.Quadrado;

public class Ambiente {

	private Map<Localizacao, Quadrado> arena = new HashMap<Localizacao, Quadrado>();

	private List<AmbienteListener> listeners = new ArrayList<AmbienteListener>();

	private List<Peca> pecasDisponiveis = new ArrayList<Peca>();

	public Ambiente() {
	}

	public Ambiente(Map<Localizacao, Quadrado> preenchimento) {
		this();
		for (Localizacao loc : preenchimento.keySet()) {
			arena.put(loc, preenchimento.get(loc));
		}
	}

	public Map<Localizacao, Quadrado> getArena() {
		return arena;
	}

	public void setArena(Map<Localizacao, Quadrado> arena) {
		this.arena = arena;
	}

	public boolean verificaPecaEncaixa(int linha, int coluna, Peca peca) {
		for (Localizacao loc : peca.getFormato().keySet()) {
			// Verifica se algum espaço está ocupado
			Localizacao novaLoc = new Localizacao((linha - 1) + loc.getLinha(), (coluna - 1) + loc.getColuna());
			if (arena.containsKey(novaLoc)) {
				return false;
				// Verifica se passa dos limites
			} else if ((linha - 1) + loc.getLinha() > 10 || (coluna - 1) + loc.getColuna() > 10) {
				return false;
			} else if ((linha - 1) + loc.getLinha() < 1 || (coluna - 1) + loc.getColuna() < 1) {
				return false;
			}
		}
		return true;
	}

	public void adicionarPeca(int linha, int coluna, Peca peca) {
		if (verificaPecaEncaixa(linha, coluna, peca)) {
			HashMap<Localizacao, Quadrado> novosQuadrados = new HashMap<Localizacao, Quadrado>();
			Localizacao novaLoc;
			Quadrado novoQuadrado;
			for (Localizacao loc : peca.getFormato().keySet()) {
				novaLoc = new Localizacao((linha - 1) + loc.getLinha(), (coluna - 1) + loc.getColuna());
				novoQuadrado = peca.getFormato().get(loc);
				arena.put(novaLoc, novoQuadrado);
				novosQuadrados.put(novaLoc, novoQuadrado);
			}
			if (Jogo.isEmDebug()) {
				System.out.println("Peça adicionada:\n" + peca);
			}
			fireAmbienteEvent(new Evento(TipoEvento.PECA_ADICIONADA, novosQuadrados, null));
		}
	}

	public boolean disponiveisTemChance() {
		for (Peca peca : pecasDisponiveis) {
			for (int linha = 1; linha <= 10; linha++) {
				for (int col = 1; col <= 10; col++) {
					if (verificaPecaEncaixa(linha, col, peca)) {
						return true;
					}
				}
			}
		}
		fireAmbienteEvent(new Evento(TipoEvento.GAME_OVER, null, null));
		return false;
	}

	public void limparArena() {
		arena.clear();
		Evento evento = new Evento(TipoEvento.ARENA_LIMPA, null, null);
		fireAmbienteEvent(evento);
	}

	public void addAmbienteListener(AmbienteListener lis) {
		listeners.add(lis);
	}

	public void removeAmbienteListener(AmbienteListener lis) {
		listeners.remove(lis);
	}

	private void fireAmbienteEvent(Evento evt) {
		for (AmbienteListener listener : listeners) {
			listener.ambienteAlterado(evt);
		}
	}

	public void oferecerPecas(List<Peca> novasPecas) {
		synchronized (this.pecasDisponiveis) {
			this.pecasDisponiveis.addAll(novasPecas);
			Evento evento = new Evento(TipoEvento.NOVAS_PECAS_DISPONIVEIS, null, novasPecas);
			fireAmbienteEvent(evento);
		}
	}

	public List<Peca> getPecasDisponiveis() {
		synchronized (pecasDisponiveis) {
			return Collections.unmodifiableList(pecasDisponiveis);
		}
	}

	public void removerPecaDisponivel(Peca peca) {
		synchronized (pecasDisponiveis) {
			pecasDisponiveis.remove(peca);

			fireAmbienteEvent(new Evento(TipoEvento.PECA_DISP_REMOVIDA, null, Arrays.asList(new Peca[] { peca })));
		}
	}

	public boolean containsPecaDisponivel(Peca peca) {
		return pecasDisponiveis.contains(peca);
	}

	public int getPecasDisponiveisSize() {
		return pecasDisponiveis.size();
	}

	public void limpaLinha(int linha) {
		HashMap<Localizacao, Quadrado> quadrados = new HashMap<Localizacao, Quadrado>();
		Localizacao tempLoc;
		for (int j = 1; j <= 10; j++) {
			tempLoc = new Localizacao(linha, j);
			quadrados.put(tempLoc, null);
			arena.remove(tempLoc);
		}
		fireAmbienteEvent(new Evento(TipoEvento.QUADRADOS_SUMIRAM, quadrados, null));
	}

	public void limpaColuna(int coluna) {
		HashMap<Localizacao, Quadrado> quadrados = new HashMap<Localizacao, Quadrado>();
		Localizacao tempLoc;
		for (int j = 1; j <= 10; j++) {
			tempLoc = new Localizacao(j, coluna);
			quadrados.put(tempLoc, null);
			arena.remove(tempLoc);
		}
		fireAmbienteEvent(new Evento(TipoEvento.QUADRADOS_SUMIRAM, quadrados, null));
	}
}
