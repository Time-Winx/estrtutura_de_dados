package mapaOrdenadoABB.implementacao.position;

import java.util.Iterator;
import java.util.NoSuchElementException;

import mapaOrdenadoABB.implementacao.TADListaDeNodos.*;

public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	// Cria um elemento iterator
	public ElementIterator(PositionList<E> L) {
		list = L;
		cursor = (list.isEmpty()) ? null : list.first();
	}
	// Retorna se o iterator tem ou n�o um pr�ximo objeto.
	public boolean hasNext() { return (cursor != null); }
	
	// Retorna o pr�ximo objeto do iterator.
	public E next() throws NoSuchElementException {
		if (cursor == null) throw new NoSuchElementException("No next element");
			E toReturn = cursor.element();
			cursor = (cursor == list.last()) ? null : list.next(cursor);
			return toReturn;
	}

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("remove");
	}
}