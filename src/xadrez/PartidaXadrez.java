package xadrez;

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
	
	private void placeNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.placePeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
	}
	
	private void InicioPartida() {
		placeNovaPeca('a', 8, new Torre(tabuleiro,Cor.WHITE));
		placeNovaPeca('h', 8, new Torre(tabuleiro,Cor.WHITE));
		placeNovaPeca('d', 8, new King(tabuleiro,Cor.WHITE));
		placeNovaPeca('a', 1, new Torre(tabuleiro,Cor.BLACK));
		placeNovaPeca('h', 1, new Torre(tabuleiro,Cor.BLACK));
		placeNovaPeca('d', 1, new King(tabuleiro,Cor.BLACK));
	}
}
