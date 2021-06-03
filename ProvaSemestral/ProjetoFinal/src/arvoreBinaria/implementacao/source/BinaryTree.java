package arvoreBinaria.implementacao.source;
import arvoreBinaria.implementacao.exceptions.*;
import arvoreBinaria.implementacao.position.*;

public interface BinaryTree<E> extends Tree<E> {
	// Retorna o filho da esquerda do nodo.	
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	// Retorna o filho da direita do nodo.
	public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	// Retorna se o nodo tem filho da esquerda.
	public boolean hasLeft(Position<E> v) throws InvalidPositionException;
	// Retorna se o nodo tem filho da direita.
	public boolean hasRight(Position<E> v) throws InvalidPositionException;
}