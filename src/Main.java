import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String operation;
        double a;
        double b = 1;
        boolean valid = false;

        // Choosing operation
        do {
            System.out.print("Please enter your operation [/ * + -] of choice: ");
            operation = input.nextLine();
        } while (!operation.equals("/") && !operation.equals("*") && !operation.equals("+") && !operation.equals("-"));

        // Picking First Number
        System.out.print("Please enter your first number: ");
        while (!input.hasNextDouble() ) {
            input.next();
            System.out.print("Not a number, try again: ");
        }
        a = input.nextDouble();
        input.nextLine();

        // Picking Second Number
        System.out.print("Please enter your second number: ");
        String temp = input.nextLine();
        while (!valid) {
            if (temp.equals("0") && operation.equals("/")) {
                System.out.print("Cannot divide by zero, please enter an appropriate number: ");
                temp = input.nextLine();
                continue;
            }
            try {
                b = Double.parseDouble(temp);
            }
            catch (NumberFormatException e) {
                System.out.print("Not a number, please try again: ");
                temp = input.nextLine();
                continue;
            }
            valid = true;
        }

        switch (operation) {
            case "/" -> System.out.println(a / b);
            case "*" -> System.out.println(a * b);
            case "+" -> System.out.println(a + b);
            case "-" -> System.out.println(a - b);
            default -> System.out.println("Something went wrong!");
        }
    }
}