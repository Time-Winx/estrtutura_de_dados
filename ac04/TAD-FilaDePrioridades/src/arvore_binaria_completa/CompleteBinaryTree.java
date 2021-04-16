package arvore_binaria_completa;
import tad_lista_de_nodos.*;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
    public Position<E> add(E elem);
    public E remove();
}