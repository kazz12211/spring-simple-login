package tsubakicraftjp.springsimplelogin.exception;

public class InvalidPasswordException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidPasswordException(String string) {
        super(string);
    }    
}