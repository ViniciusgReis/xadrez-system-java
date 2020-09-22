package tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		
		if( linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro na cria��o do Tabuleiro: � necess�rio ao menos 1 linha e 1 coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if( !existePosicao(linha,coluna)) {
			throw new TabuleiroException("A posi��o informada n�o existe no tabuleiro!");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if( !existePosicao(posicao)) {
			throw new TabuleiroException("A posi��o informada n�o existe no tabuleiro!");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void placePeca(Peca peca, Posicao posicao) {
		if( contemPeca(posicao)) {
			throw new TabuleiroException("J� existe uma pe�a na posi��o"+posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removePiece(Posicao posicao) {
		if( !existePosicao(posicao)) {
			throw new TabuleiroException("A posi��o informada n�o existe no tabuleiro!");
		}
		if (peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	
	private boolean existePosicao(int linha, int coluna) {
		return linha >=0 && linha < linhas && coluna >=0 && coluna < colunas;
	}
	public boolean existePosicao(Posicao posicao){
		return existePosicao(posicao.getLinha(),posicao.getColuna());
	}
	
	public boolean contemPeca(Posicao posicao) {
		if( !existePosicao(posicao)) {
			throw new TabuleiroException("J� existe uma pe�a na posi��o"+posicao);
		}
		return peca(posicao) != null;
	}

}
