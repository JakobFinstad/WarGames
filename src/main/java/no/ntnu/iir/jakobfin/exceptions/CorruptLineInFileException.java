package no.ntnu.iir.jakobfin.exceptions;

/**
 * An exception for corrupted lines in a file.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class CorruptLineInFileException extends Exception{
    private String message;

    /**
     * Default constructor with preset message.
     */
    public CorruptLineInFileException(){
        this.message = "There was a corrupted line in the file";
    }

    /**
     * Constructor with custom message for the more advance exception handlers.
     *
     * @param msg the message for this exception
     */
    public CorruptLineInFileException(String msg){
        this.message = msg;
    }

    /**
     * Get the message for this exception.
     *
     * @return the message for exception
     */
    public String getMessage(){
        return this.message;
    }
}
