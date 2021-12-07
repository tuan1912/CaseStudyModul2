package exception;

public class TooLong extends Exception{
    String errorMessage;
    public TooLong(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        System.out.println(errorMessage);
        return errorMessage;
    }

}