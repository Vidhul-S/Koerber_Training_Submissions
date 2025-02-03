package day3_4LabAssignment.arthematic;

public class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {

        super(message);
    }

    @Override
    public String toString() {
        return "DivideByZeroException" + this.getMessage();
    }
}
