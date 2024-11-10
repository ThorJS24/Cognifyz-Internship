
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Generator!");

        // Get desired length of password
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        // Get user preferences for password content
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        // Generate and display the password
        String password = generatePassword(length, includeLowercase, includeUppercase, includeNumbers, includeSpecialChars);
        System.out.println("Generated Password: " + password);

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeNumbers, boolean includeSpecialChars) {
        Random random = new Random();  // Create a Random object inside the method
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?";

        StringBuilder allChars = new StringBuilder();
        if (includeLowercase) {
            allChars.append(lowercase);
        }
        if (includeUppercase) {
            allChars.append(uppercase);
        }
        if (includeNumbers) {
            allChars.append(numbers);
        }
        if (includeSpecialChars) {
            allChars.append(specialChars);
        }

        if (allChars.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allChars.length());
            password.append(allChars.charAt(index));
        }

        return password.toString();
    }
}
