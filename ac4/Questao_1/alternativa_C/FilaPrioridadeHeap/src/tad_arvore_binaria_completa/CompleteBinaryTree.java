package tad_arvore_binaria_completa;

import commons.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E>{
    public Position<E> add(E elem);
    public E remove();
}
