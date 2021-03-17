package tarefa_4;

public interface Pilha<E> {

    /**
     * @return Tamanho da pilha
     */
    int size();

    /**
     * @return True se a pilha estiver vazia e False se a pilha ão estiver
     */
    boolean isEmpty();

    /**
     * @param e elemento a ser inserido
     */
    void push(E e);

    /**
     * Retorna o elemento no topo da lista, sem remove-lo.
     *
     * @return Elemento no topo da pilha
     */
    E top();


    /**
     * Retorna e remove o elemento no topo da pilha
     *
     * @return Elemento no topo da pilha
     */
    E pop();

}
