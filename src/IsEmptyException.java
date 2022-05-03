import java.util.EmptyStackException;

public class IsEmptyException extends Exception {
    public IsEmptyException(String msg){
        super(msg);
    }

    public IsEmptyException(Exception ex){
        super(ex);
    }
}
