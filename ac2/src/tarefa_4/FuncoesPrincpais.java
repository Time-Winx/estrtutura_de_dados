package tarefa_4;

import java.util.LinkedList;

public class FuncoesPrincpais {

    public <E> void reverter_array(E[] a) {
        PilhaLSE<E> buffer = new PilhaLSE<>(a.length);
        for (E e : a) buffer.push(e);
        for (int i = 0; i < a.length; i++)
            a[i] = buffer.pop();
    }


    public boolean confere_tag(String expressao) {
        final String opening = "({[";
        final String closing = ")}]";

        Pilha<Character> buffer = new PilhaLSE<>();
        for (char c : expressao.toCharArray()) {
            if (opening.indexOf(c) != -1)
                buffer.push(c);
            else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty())
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false;
            }
        }
        return buffer.isEmpty();
    }
}
