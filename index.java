import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, String> userDatabase = new HashMap<>();
    private static final String GRAPHICAL_PASSWORD = "secureGraphicalCode"; // Example graphical password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        userDatabase.put("Meghana", "password@123"); // Username and password

        System.out.println("Welcome to the Simple Authentication System");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                login(scanner);
                break;
            case 2:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            System.out.println("Login successful!");
            if (askForGraphicalPassword(scanner)) {
                System.out.println("Graphical password correct. Access granted.");
            } else {
                System.out.println("Incorrect graphical password.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static boolean askForGraphicalPassword(Scanner scanner) {
        System.out.print("Enter graphical password: ");
        String input = scanner.nextLine();
        return GRAPHICAL_PASSWORD.equals(input);
    }
}
