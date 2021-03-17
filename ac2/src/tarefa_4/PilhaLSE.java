package tarefa_4;

public class PilhaLSE<E> implements Pilha<E>{
    //    TODO: Implementar lista simplesmente encadeada

    private LSE<E> list = new LSE<>();
    public PilhaLSE() {}

    public PilhaLSE(int length) {

    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E top() {
        return list.first();
    }

    public E pop() {
        return list.removeFirst();
    }
}
