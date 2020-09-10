package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.King;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		InicioPartida();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i< tabuleiro.getLinhas(); i++) {
			for (int j = 0; j< tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
			}
		}
		return mat;
	}
	
	private void InicioPartida() {
		tabuleiro.placePeca(new Torre(tabuleiro,Cor.WHITE), new Posicao(0, 0));
		tabuleiro.placePeca(new Torre(tabuleiro,Cor.WHITE), new Posicao(0, 7));
		tabuleiro.placePeca(new King(tabuleiro,Cor.WHITE), new Posicao(0, 3));
		tabuleiro.placePeca(new Torre(tabuleiro,Cor.BLACK), new Posicao(7, 0));
		tabuleiro.placePeca(new Torre(tabuleiro,Cor.BLACK), new Posicao(7, 7));
		tabuleiro.placePeca(new King(tabuleiro,Cor.BLACK), new Posicao(7, 3));
	}
}
