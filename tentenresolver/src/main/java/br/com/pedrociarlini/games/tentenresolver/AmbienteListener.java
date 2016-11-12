package br.com.pedrociarlini.games.tentenresolver;

import java.util.List;
import java.util.Map;

import br.com.pedrociarlini.games.tentenresolver.entity.Localizacao;
import br.com.pedrociarlini.games.tentenresolver.entity.Peca;
import br.com.pedrociarlini.games.tentenresolver.entity.Quadrado;

public interface AmbienteListener {

	public void ambienteAlterado(Evento evt);

	static enum TipoEvento {
		PECA_ADICIONADA, ARENA_LIMPA, NOVAS_PECAS_DISPONIVEIS, PECA_DISP_REMOVIDA, GAME_OVER, QUADRADOS_SUMIRAM;
	}

	public static class Evento {
		private TipoEvento tipo;

		private Map<Localizacao, Quadrado> quadrados;

		private List<Peca> pecas;

		public Evento(TipoEvento tipoEvento, Map<Localizacao, Quadrado> quadrados, List<Peca> pecas) {
			setTipo(tipoEvento);
			setPeca(pecas);
			setQuadrados(quadrados);
		}

		public Map<Localizacao, Quadrado> getQuadrados() {
			return quadrados;
		}

		public void setQuadrados(Map<Localizacao, Quadrado> quadrados) {
			this.quadrados = quadrados;
		}

		public List<Peca> getPeca() {
			return pecas;
		}

		public void setPeca(List<Peca> pecas) {
			this.pecas = pecas;
		}

		public TipoEvento getTipo() {
			return tipo;
		}

		public void setTipo(TipoEvento tipo) {
			this.tipo = tipo;
		}
	}
}
