package mapaOrdenadoABB.implementacao.Exceptions;

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException {
    public EmptyListException(String err) { 
        super(err); 
    }

}