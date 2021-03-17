package source;

public class ArrayIndexList<E> implements Indexlist<E> {
	private E[] A; // arranjo que armazena os elementos da lista
	private int capacity = 16; // tamanho inicial do arranjo 
	private int size = 0;
	
	@SuppressWarnings("unchecked")

	public ArrayIndexList() {
		A = (E[]) new Object[capacity]; // o comiplador pode gerar alerta aqui, mas está tudo ok.
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void add(int r, E e) throws IndexOutOfBoundsException {
		checkIndex(r, size() + 1);

		if (size == capacity) { // an overflow
			capacity *= 2;
			@SuppressWarnings("unchecked")
			E[] B = (E[]) new Object[capacity];
			for (int i = 0; i < size; i++) B[i] = A[i];
			A = B;
		}

		for (int i = size - 1; i >= r; i--) // desloca os elementos para cima
			A[i + 1] = A[i];
		A[r] = e;
		size++;
	}

	@Override
	public E get(int r) throws IndexOutOfBoundsException {
		checkIndex(r, size());

		return A[r];
	}

	@Override
	public E remove(int r) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		E temp = A[r];

		for (int i = r; i < size - 1; i++) // desloca os elemento para baixo
			A[i] = A[i + 1];
		size--;
		return temp;
	}

	@Override
	public E set(int r, E e) throws IndexOutOfBoundsException {
		checkIndex(r, size());
		E temp = A[r];
		A[r] = e;

		return temp;
	}
	
	protected void checkIndex(int r, int n) throws IndexOutOfBoundsException {
		if (r < 0 || r >= n) throw new IndexOutOfBoundsException("Illegal index: " + r);
	}

	public String toString() {
		String toReturn = "(";
		if (size() == 0) return "()";
		for (int i = 0; i < size(); i++) toReturn += A[i].toString() + ", ";
		return toReturn.substring(0, toReturn.length() - 2) + ")";
	}
}
