package arvoreBinaria.implementacao.exceptions;
/* Retorna uma exce��o quando se tenta criar uma ra�z de
* uma �rvore que n�o est� vazia. */
@SuppressWarnings("serial")
public class NonEmptyTreeException
		extends RuntimeException {
	public NonEmptyTreeException(String err) { super(err); }
}