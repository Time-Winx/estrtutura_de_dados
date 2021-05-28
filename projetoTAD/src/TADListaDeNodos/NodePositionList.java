package TADListaDeNodos;

import Exceptions.*;
import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E> {
    protected int numElts;
    protected DNode<E> header, trailer;

    public NodePositionList() {
        numElts = 0;
        header = new DNode<E>(null, null, null);
        trailer = new DNode<E>(header, null, null);
        header.setNext(trailer);

    }

    protected DNode<E> checkPosition(Position<E> p) throws InvalidPositionException {
        if (p == null) throw new InvalidPositionException("Possição passa é nula");
        if (p == header) throw new InvalidPositionException("A posição da cabeça é invalida");
        if (p == trailer) throw new InvalidPositionException("A posição da cauda é invalida");

        try {
            DNode<E> temp = (DNode<E>) p;
            if ((temp.getPrev() == null) || (temp.getNext() == null))
                throw new InvalidPositionException("A posição não pertence a uma NodeList válida");
            return temp;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("A posição é do tipo errado para esta lista");
        }
    }
    public int size() {
        return numElts;
    }
    public boolean isEmpty() {
        return (numElts == 0);
    }
    public Position<E> first() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("A lista está vazia");
        return header.getNext();
    }
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
        DNode<E> v = checkPosition(p);
        DNode<E> prev = v.getPrev();
        if (prev == header) throw new BoundaryViolationException("Não é possível avançar além do início da lista");
        return prev;
    }
    public void addBefore(Position<E> p, E element) throws InvalidPositionException {
       DNode<E> v = checkPosition(p);
       numElts++;
       DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
       v.getPrev().setNext(newNode);
       v.setPrev(newNode);
    }
    public void addFirst(E element) {
        numElts++;
        DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
    }
    public E remove(Position<E> p) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts--;
        DNode<E> vPrev = v.getPrev();
        DNode<E> vNext = v.getNext();
        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);
        E vElem = v.element();
        v.setNext(null);
        v.setPrev(null);
        return vElem;
    }
    public E set(Position<E> p, E element) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        E oldElt = v.element();
        v.setElement(element);
        return oldElt;
    }
    public Position<E> last() {
        if (isEmpty()) throw new EmptyListException("Lista vazia");
        return trailer.getPrev();
    }
    public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
       DNode<E> v = checkPosition(p);
       DNode<E> next = v.getNext();
       if (next == trailer) throw new BoundaryViolationException("Não é possível avançar além da finalização da lista");
       return next;
    }
    public void addLast(E e) {
        numElts++;
        DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, e);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
    }
    public void addAfter(Position<E> p, E e) throws InvalidPositionException {
        DNode<E> v = checkPosition(p);
        numElts++;
        DNode<E> newNode = new DNode<E>(v, v.getNext(), e);
        v.getNext().setPrev(newNode);
        v.setNext(newNode); 
    }
    public static <E> String toString(NodePositionList<E> nodePositionList) {
        String s = "";
        for (E i: nodePositionList) {s += ", " + i; }
        s = (s.length() == 0 ? s : s.substring(2));
        return "[" + s + "]";
    }
    public Iterator<E> iterator() { 
        return new ElementIterator<E>(this); 
    }
    public String toString() { 
        return toString(this); 
    }
}
