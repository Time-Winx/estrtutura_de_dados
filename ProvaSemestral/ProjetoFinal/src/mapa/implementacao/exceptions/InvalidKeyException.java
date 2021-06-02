package mapa.implementacao.exceptions;

/* Exceção lançada se a posição fornecida como argumento não é válida (por
* exemplo, se é uma referência nula ou não tem lista associada). */

@SuppressWarnings("serial")
public class InvalidKeyException extends RuntimeException {
	public InvalidKeyException(String err) { super(err); }
}