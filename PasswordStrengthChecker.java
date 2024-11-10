
import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password input
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Analyze password strength
        String feedback = checkPasswordStrength(password);

        // Display feedback
        System.out.println(feedback);
    }

    public static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialCharacters = "!@#$%^&*()-_+=<>?/";

        // Check each character of the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (specialCharacters.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        // Determine password strength based on criteria
        if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Password Strength: Strong";
        } else if (length >= 6 && hasUppercase && hasLowercase && (hasDigit || hasSpecialChar)) {
            return "Password Strength: Medium";
        } else {
            return "Password Strength: Weak";
        }
    }
}
