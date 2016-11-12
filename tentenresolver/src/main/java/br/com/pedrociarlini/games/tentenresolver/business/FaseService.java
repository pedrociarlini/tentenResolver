package br.com.pedrociarlini.games.tentenresolver.business;

import java.util.HashMap;
import java.util.Map;

import br.com.pedrociarlini.games.tentenresolver.entity.Cor;
import br.com.pedrociarlini.games.tentenresolver.entity.Localizacao;
import br.com.pedrociarlini.games.tentenresolver.entity.Quadrado;

public class FaseService {
	private static final HashMap<Integer, Map<Localizacao, Quadrado>> fases = new HashMap<Integer, Map<Localizacao, Quadrado>>();

	static {
		HashMap<Localizacao, Quadrado> conf = new HashMap<Localizacao, Quadrado>();
		conf.put(loc(1, 1), quad(Cor.CINZA_ESCURO, true, 10));
		conf.put(loc(1, 10), quad(Cor.CINZA_ESCURO, true, 10));
		conf.put(loc(2, 2), quad(Cor.CINZA_ESCURO, true, 3));
		conf.put(loc(2, 9), quad(Cor.CINZA_ESCURO, true, 3));
		conf.put(loc(3, 3), quad(Cor.CINZA_ESCURO, true, 1));
		conf.put(loc(3, 7), quad(Cor.CINZA_ESCURO, true, 1));
		conf.put(loc(5, 5), quad(Cor.CINZA_ESCURO, true, 2));
		conf.put(loc(5, 6), quad(Cor.CINZA_ESCURO, true, 2));
		conf.put(loc(6, 5), quad(Cor.CINZA_ESCURO, true, 2));
		conf.put(loc(6, 6), quad(Cor.CINZA_ESCURO, true, 2));

		conf.put(loc(10, 1), quad(Cor.CINZA_ESCURO, true, 10));
		conf.put(loc(10, 10), quad(Cor.CINZA_ESCURO, true, 10));
		conf.put(loc(9, 2), quad(Cor.CINZA_ESCURO, true, 3));
		conf.put(loc(9, 9), quad(Cor.CINZA_ESCURO, true, 3));
		conf.put(loc(7, 3), quad(Cor.CINZA_ESCURO, true, 1));
		conf.put(loc(7, 7), quad(Cor.CINZA_ESCURO, true, 1));

		fases.put(95, conf);
	}

	public final static Localizacao loc(int l, int c) {
		return new Localizacao(l, c);
	}

	public final static Quadrado quad(Cor cor, boolean b, int i) {
		return new Quadrado(cor, b, i);
	}

	public Map<Localizacao, Quadrado> getFase(Integer numero) {
		return fases.get(numero);
	}
}
