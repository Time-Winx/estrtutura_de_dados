package TADPilha;

import Exceptions.EmptyStackException;

public interface Pilha<E> {
    
    public int size();

    public boolean isEmpty();

    public E top() throws EmptyStackException;

    public void push(E element);

    public E pop() throws EmptyStackException;
    
}
