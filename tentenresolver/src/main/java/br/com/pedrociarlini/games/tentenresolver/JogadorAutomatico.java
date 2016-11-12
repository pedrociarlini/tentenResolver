package br.com.pedrociarlini.games.tentenresolver;

import br.com.pedrociarlini.games.tentenresolver.entity.Peca;

public class JogadorAutomatico {

	private Mecanica mecanica;
	private Thread thread;

	public JogadorAutomatico(Mecanica mec) {
		mecanica = mec;
		thread = new Thread(new Runnable() {

			private boolean adicionou = false;

			public void run() {
				while (!mecanica.isGameOver()) {
					Peca peca = mecanica.getAmbiente().getPecasDisponiveis().get(0);
					if (Jogo.isEmDebug()) {
						System.out.print("Checando peca:\n" + peca);
					}
					adicionou = false;
					for (int linha = 1; linha <= 10; linha++) {
						for (int col = 1; col <= 10; col++) {
							if (mecanica.getAmbiente().verificaPecaEncaixa(linha, col, peca)) {
								if (Jogo.isEmDebug()) {
									System.out.print("Adicionadno peca:\n" + peca);
								}
								mecanica.adicionarPeca(linha, col, peca);
								mecanica.pausa();
								adicionou = true;
								break;
							}
						}
						if (adicionou)
							break;
					}
				}
			}
		});
	}

	public void start() {
		thread.start();
	}
}
