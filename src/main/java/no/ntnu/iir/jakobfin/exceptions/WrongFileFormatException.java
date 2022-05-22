package no.ntnu.iir.jakobfin.exceptions;

/**
 * A class to throw if the entered file was in the wrong format.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class WrongFileFormatException extends Exception{
    private String message;

    /**
     * Constructor for the exception.
     */
    public WrongFileFormatException(){
        this.message = "The entered file was in the wrong format. Format need is 'example.csv'";
    }

    /**
     * Constructor for adding own text to the message.
     *
     * @param message the message that shall be entered
     */
    public WrongFileFormatException(String message){
        this.message=message;
    }

    /**
     * Get the message for this exception.
     *
     * @return the message for this exception
     */
    public String getMessage(){
        return this.message;
    }
}
