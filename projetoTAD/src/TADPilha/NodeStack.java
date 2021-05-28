package TADPilha;

import Exceptions.EmptyStackException;

public class NodeStack<E> implements Pilha<E> {
    protected Node<E> top;
    protected int size;
    
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        if (top == null)
            return true;
        return false;
    }
    public void push(E elem) {
        Node<E> v = new Node<E>(elem, top);
        top = v;
        size ++;
    }
    public E top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException("Pilha cheia");
        return top.getElement();
    }
    public E pop() throws EmptyStackException {
        Node<E> aux = top;

        if (isEmpty()) throw new EmptyStackException("Pilha cheia");
        E temp = top.getElement();
        top = top.getNext();
        aux.setNext(null);
        size--;
        return temp;
    }
    public String toString() {
        String s;
        Node<E> p = top;
        s = "[";
        while (p != null) {
            s += p.getElement();
            s += ", ";
            p = p.getNext();
        }
        if (s.length() > 1)
            s = s.substring(0, s.length() - 1);
        return s + "]";
        }
}
