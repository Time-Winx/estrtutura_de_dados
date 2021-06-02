package mapa.implementacao.exceptions;

/* Exceção lançada se for feita uma tentativa de acessar um elemento cuja
* posição está fora do intervalo de posições da lista (por exemplo, chamando-se
* o método next sobre a última posição da sequência). */

@SuppressWarnings("serial")
public class BounaryViolationException extends RuntimeException {
	public BounaryViolationException(String err) { super(err); }
}