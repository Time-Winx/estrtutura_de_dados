package TADFila;
import Exceptions.*;

public class ArrayQueue<E> implements Queue<E> {
	protected E Q[];
	private int f = 0, r = 0;
	private int N = 10;
	
	public ArrayQueue() {
		Q = (E[]) new Object[N];
	}
	
	public int size() {
		return (N - f + r) % N;
	}

	public boolean isEmpty() {
		return (f == r);
	}

	public E front() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("Queue is empty.");
		return Q[f];
	}

	public void enqueue(E elem) throws FullQueueException {
		if(size() == N - 1) throw new EmptyQueueException("Queue is full.");
		Q[r] = elem;
		r = (r + 1) % N;
	}

	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) throw new EmptyQueueException("Queue is empty.");
		E temp = Q[f];
		Q[f] = null;
		f = (f + 1) % N;
		return temp;
	}
	
	public String toString() {
		String s;
		s = "[";
		//if(size() > 0) s += Q[0];
		if(size() > 0) {
			for(int i = 0; i <= size(); i++) {
				if(Q[i] == null) {}
				else {s += Q[i] + ", ";}
			}
		}
		if(s.length() > 1) s = s.substring(0, s.length() - 2);
		return s + "]";
	}
}