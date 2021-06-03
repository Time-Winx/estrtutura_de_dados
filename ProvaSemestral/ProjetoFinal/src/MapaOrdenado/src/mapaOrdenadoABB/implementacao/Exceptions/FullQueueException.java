package mapaOrdenadoABB.implementacao.Exceptions;
@SuppressWarnings("serial")
public class FullQueueException extends RuntimeException{
    public FullQueueException(String err) {
        super(err);
    }
}
