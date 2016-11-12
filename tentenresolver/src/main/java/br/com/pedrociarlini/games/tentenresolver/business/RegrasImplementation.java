package br.com.pedrociarlini.games.tentenresolver.business;

import java.util.HashMap;
import java.util.Random;

import br.com.pedrociarlini.games.tentenresolver.entity.Cor;
import br.com.pedrociarlini.games.tentenresolver.entity.Localizacao;
import br.com.pedrociarlini.games.tentenresolver.entity.Peca;
import br.com.pedrociarlini.games.tentenresolver.entity.Quadrado;

public class RegrasImplementation {

	private static final HashMap<Integer, Peca> pecas = new HashMap<Integer, Peca>();

	static {
		Peca peca = new Peca();
		peca.getFormato().put(new Localizacao(1, 1), new Quadrado(Cor.ROSEO, true, 1));
		getPecas().put(1, peca);

		peca = new Peca();
		peca.getFormato().put(new Localizacao(1, 1), new Quadrado(Cor.LARANJA, true, 1));
		peca.getFormato().put(new Localizacao(1, 2), new Quadrado(Cor.LARANJA, true, 1));
		getPecas().put(2, peca);

		peca = new Peca();
		peca.getFormato().put(new Localizacao(1, 1), new Quadrado(Cor.LARANJA, true, 1));
		peca.getFormato().put(new Localizacao(2, 1), new Quadrado(Cor.LARANJA, true, 1));
		getPecas().put(3, peca);

		peca = new Peca();
		peca.getFormato().put(new Localizacao(1, 1), new Quadrado(Cor.ROXO, true, 1));
		peca.getFormato().put(new Localizacao(2, 1), new Quadrado(Cor.ROXO, true, 1));
		peca.getFormato().put(new Localizacao(3, 1), new Quadrado(Cor.ROXO, true, 1));
		getPecas().put(4, peca);

		peca = new Peca();
		peca.getFormato().put(new Localizacao(1, 1), new Quadrado(Cor.ROXO, true, 1));
		peca.getFormato().put(new Localizacao(1, 2), new Quadrado(Cor.ROXO, true, 1));
		peca.getFormato().put(new Localizacao(1, 3), new Quadrado(Cor.ROXO, true, 1));
		getPecas().put(5, peca);

		peca = new Peca();
		for (int i = 1; i <= 4; i++) {
			peca.getFormato().put(new Localizacao(1, i), new Quadrado(Cor.AMARELO, true, 1));
		}
		getPecas().put(6, peca);

		peca = new Peca();
		for (int i = 1; i <= 4; i++) {
			peca.getFormato().put(new Localizacao(i, 1), new Quadrado(Cor.AMARELO, true, 1));
		}
		getPecas().put(7, peca);

		peca = new Peca();
		peca.getFormato().put(new Localizacao(1, 1), new Quadrado(Cor.AZUL_CLARO, true, 1));
		peca.getFormato().put(new Localizacao(2, 1), new Quadrado(Cor.AZUL_CLARO, true, 1));
		peca.getFormato().put(new Localizacao(1, 2), new Quadrado(Cor.AZUL_CLARO, true, 1));
		peca.getFormato().put(new Localizacao(2, 2), new Quadrado(Cor.AZUL_CLARO, true, 1));
		getPecas().put(8, peca);

		peca = new Peca();
		for (int i = 1; i <= 5; i++) {
			peca.getFormato().put(new Localizacao(1, i), new Quadrado(Cor.AZUL, true, 1));
		}
		getPecas().put(9, peca);

		peca = new Peca();
		for (int i = 1; i <= 5; i++) {
			peca.getFormato().put(new Localizacao(i, 1), new Quadrado(Cor.AZUL, true, 1));
		}
		getPecas().put(10, peca);

		peca = new Peca();
		for (int i = 1; i <= 3; i++) {
			peca.getFormato().put(new Localizacao(i, 1), new Quadrado(Cor.VERMELHO, true, 1));
		}
		peca.getFormato().put(new Localizacao(3, 2), new Quadrado(Cor.VERMELHO, true, 1));
		peca.getFormato().put(new Localizacao(3, 3), new Quadrado(Cor.VERMELHO, true, 1));
		getPecas().put(11, peca);

		peca = new Peca();
		for (int i = 1; i <= 3; i++) {
			peca.getFormato().put(new Localizacao(1, i), new Quadrado(Cor.VERMELHO, true, 1));
		}
		peca.getFormato().put(new Localizacao(2, 3), new Quadrado(Cor.VERMELHO, true, 1));
		peca.getFormato().put(new Localizacao(3, 3), new Quadrado(Cor.VERMELHO, true, 1));
		getPecas().put(12, peca);

		peca = new Peca();
		for (int i = 1; i <= 3; i++) {
			peca.getFormato().put(new Localizacao(1, i), new Quadrado(Cor.VERMELHO, true, 1));
		}
		peca.getFormato().put(new Localizacao(2, 1), new Quadrado(Cor.VERMELHO, true, 1));
		peca.getFormato().put(new Localizacao(3, 1), new Quadrado(Cor.VERMELHO, true, 1));
		getPecas().put(13, peca);

		peca = new Peca();
		for (int i = 1; i <= 3; i++) {
			peca.getFormato().put(new Localizacao(3, i), new Quadrado(Cor.VERMELHO, true, 1));
		}
		peca.getFormato().put(new Localizacao(1, 3), new Quadrado(Cor.VERMELHO, true, 1));
		peca.getFormato().put(new Localizacao(2, 3), new Quadrado(Cor.VERMELHO, true, 1));
		getPecas().put(14, peca);

		peca = new Peca();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				peca.getFormato().put(new Localizacao(i, j), new Quadrado(Cor.AZUL_CLARO, true, 1));
			}
		}
		getPecas().put(15, peca);
	}

	public int getNumNovasPecas() {
		return 3;
	}

	public Peca getPecaAleatoria() {
		int numPeca = new Random().nextInt(getPecas().size() - 1) + 1;
		return getPeca(numPeca);
	}

	private Peca getPeca(int numPeca) {
		return getPecas().get(numPeca);
	}

	public static HashMap<Integer, Peca> getPecas() {
		return pecas;
	}
}
