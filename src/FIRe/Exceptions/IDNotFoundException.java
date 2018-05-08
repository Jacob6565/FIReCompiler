package FIRe.Exceptions;

public class IDNotFoundException extends Exception {
    public IDNotFoundException(String name) {
        super("The name: " + name + " was not found.");
    }
}
