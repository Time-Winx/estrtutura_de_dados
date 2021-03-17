package source;

import tratamentoDeErros.EmptyQueueException;

public class NodeQueue<E> implements Queue<E> {
	private int size = 0;
	Node<E> head, tail;
	
	public NodeQueue() {
		head = tail = null;
		size = 0;
	}
	
	// [...]
	
	public void enqueue(E elem) {
		Node<E> node = new Node<E>();
		node.setElement(elem);
		node.setNext(null); // nodo será o novo nodo do final

		if (size == 0)
			head = node; // caso especial de uma lista previamente vazia
		else
			tail.setNext(node); // adiciona nodo no final da lista

		tail = node; // atualiza referência ao nodo do final
		size++;

	}

	public E dequeue() throws EmptyQueueException {
		if (size == 0) throw new EmptyQueueException("Queue is empty.");

		E tmp = head.getElement();
		head = head.getNext();
		size--;

		if (size == 0)
			tail = null;// a fila está vazia agora
		return tmp;
	}

	// [...]
	
	@Override
	public int size() {
		return size;
	}


	@Override
	public boolean isEmpty() {
		if (head == null) return true;
		return false;
	}


	@Override
	public E front() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("Queue is empty.");
		return head.getElement();
	}
	
	public String toString() {
		String s = "[";
		Node<E> p = head;
		
		while(p != null) {
			s += p.getElement();
			s += ", ";
			p = p.getNext();
		}
		if(s.length() > 1) s = s.substring(0, s.length() - 2);
		return s + "]";
	}
	
}
