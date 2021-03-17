package source;

public class Node<E> {
	// Variáveis de instância
	private E element;
	private Node<E> next;
	
	// Cria um nodo com referências nulas para os seus elementos e o próximo nodo
	public Node() { this(null, null); }
	
	// Cria um nodo com um dado elemento e o próximo nodo
	public Node(E e, Node<E> n) {
	element = e;
	next = n;
	}
	
	// Métodos de acesso:
	public E getElement() { return element; }
	public Node<E> getNext() { return next; }
	
	// Métodos modificadores:
	public void setElement(E newElem) { element = newElem; }
	public void setNext(Node<E> newNext) { next = newNext; }
}

