public class ExceptionsDemo {

    // Method throwing checked exception
    public static void checkVotingEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age " + age + " is ineligible to vote.");
        }
        System.out.println("Eligibility confirmed! Ready to vote.");
    }

    public static void main(String[] args) {
        System.out.println("--- Exception Handling Demo ---");

        // 1. Handling Unchecked (Runtime) Exception
        System.out.println("\n[1. Unchecked Exception Demo]");
        try {
            int dividend = 10;
            int divisor = 0;
            int quotient = dividend / divisor; // Throws ArithmeticException
            System.out.println("Quotient: " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("Caught Runtime Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed for ArithmeticException try-catch.");
        }

        // 2. Handling Custom Checked Exception
        System.out.println("\n[2. Checked / Custom Exception Demo]");
        try {
            checkVotingEligibility(16); // Throws custom Checked Exception
        } catch (InvalidAgeException e) {
            System.out.println("Caught Checked Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed for custom Exception try-catch.");
        }
    }
}

// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
