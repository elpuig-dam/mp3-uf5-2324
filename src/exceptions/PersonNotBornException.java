package exceptions;

public class PersonNotBornException extends Exception {

    public PersonNotBornException(String msg) {
        super(msg);
    }

    public PersonNotBornException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotBornException(Throwable cause) {
        super(cause);
    }


}
