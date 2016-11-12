package br.com.pedrociarlini.games.tentenresolver.ui;

import java.awt.Color;

import br.com.pedrociarlini.games.tentenresolver.entity.Cor;

public class ConfiguracaoUI {

	public static final int TAMANHO = 20;
	public static final int ESPACO_ENTRE = 4;
	public static final Color COR_VAIZO = new Color(40, 40, 40);

	public static Color getColor(Cor cor) {
		if (cor == Cor.VERDE) {
			return Color.GREEN;
		} else if (cor == Cor.VERMELHO) {
			return Color.RED;
		} else if (cor == Cor.VERDE_CLARO) {
			return Color.GREEN.brighter();
		} else if (cor == Cor.AZUL) {
			return Color.BLUE;
		} else if (cor == Cor.LARANJA) {
			return Color.ORANGE;
		} else if (cor == Cor.ROSEO) {
			return Color.PINK;
		} else if (cor == Cor.ROXO) {
			return new Color(175, 17, 120);
		} else if (cor == Cor.AZUL_CLARO) {
			return new Color(135, 212, 255);
		} else if (cor == Cor.AMARELO) {
			return Color.YELLOW;
		} else {
			return Color.LIGHT_GRAY;
		}
	}
}
