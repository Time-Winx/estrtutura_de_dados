package mapaOrdenadoABB.implementacao.Exceptions;

public class InvalidEntryException extends RuntimeException {
    public InvalidEntryException(String err) { 
        super(err); 
    }
}

