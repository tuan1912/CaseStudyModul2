package exception;

public class NotAPositiveInteger extends Exception{
    String errorMessage;
    public NotAPositiveInteger(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        System.err.println(errorMessage);
        return errorMessage;
    }
}