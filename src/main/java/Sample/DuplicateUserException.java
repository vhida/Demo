package Sample;

/**
 * Created by Liu Hao on 6/3/16.
 */
public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(final String message){
         super(message);
    }
}

