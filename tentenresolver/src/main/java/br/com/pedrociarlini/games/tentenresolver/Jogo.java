package br.com.pedrociarlini.games.tentenresolver;

import br.com.pedrociarlini.games.tentenresolver.business.RegrasImplementation;
import br.com.pedrociarlini.games.tentenresolver.entity.Peca;

public class Jogo {
	private static boolean emDebug = true;

	private static boolean jogarSo = true;

	private static Mecanica mecanica;

	public static void main(String[] args) {
		mecanica = new Mecanica();
		if (jogarSo) {
			new JogadorAutomatico(mecanica).start();
		}
		// exibirPecasExistentes();
	}

	public static void exibirPecasExistentes() {
		for (Peca peca : RegrasImplementation.getPecas().values()) {
			exibirPeca(peca);
		}
	}

	private static void exibirPeca(Peca peca) {

		System.out.println(peca);
	}

	public static boolean isEmDebug() {
		return emDebug;
	}

	public static void setEmDebug(boolean emDebug) {
		Jogo.emDebug = emDebug;
	}
}
