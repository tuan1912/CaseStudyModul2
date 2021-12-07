package exception;

public class OutOfTheOrdinary extends Exception{
    String errorMessage;
    public OutOfTheOrdinary(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        System.err.println(errorMessage);
        return errorMessage;
    }

}