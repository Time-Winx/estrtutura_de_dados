package TADFila;

import Exceptions.EmptyStackException;

public interface Queue<E> {

    public int size();

    public boolean isEmpty();

    public E front() throws EmptyStackException;

    public void enqueue(E element);

    public E dequeue() throws EmptyStackException;
}
