package pilha;

public class ArrayStack<E> implements Stack<E> {
	protected int capacity;
	public static final int CAPACITY = 1000;
	protected E S[];
	protected int top = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int cap) {
		capacity = cap;
		
		S = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return (top + 1);
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException("Stack is empty.");
		return S[top];
	}

	@Override
	public void push(E element) throws FullStackException {
		if(size() == capacity){
			throw new FullStackException("Stack is Full");
		}
		S[++top] = element;
	}

	@Override
	public E pop() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException("Stack is empty.");
		
		E element = S[top];
		
		S[top--] = null;
		return element;
	}
	
	public String toString() {
		String s;
		s = "[";
		if(size() > 0) s += S[0];
		if(size() > 1) {
			for(int i = 1; i <= size() - 1; i++) {
				s += ", " + S[i];
			}
		}
		return s + "]";
	}
}
