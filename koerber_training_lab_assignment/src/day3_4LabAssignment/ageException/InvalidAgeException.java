package day3_4LabAssignment.ageException;

public class InvalidAgeException extends Exception{

    public InvalidAgeException() {

        super("Invalid age Provided");
    }

    public InvalidAgeException(String message) {

        super(message);
    }
    public InvalidAgeException(String message, Throwable cause) {

        super(message, cause);
    }
    public InvalidAgeException(Throwable cause) {

        super(cause);
    }
}
