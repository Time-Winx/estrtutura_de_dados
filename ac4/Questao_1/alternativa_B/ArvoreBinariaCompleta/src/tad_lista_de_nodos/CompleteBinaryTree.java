package tad_lista_de_nodos;

import interfaces.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E>{
    public Position<E> add(E elem);
    public E remove();
}
