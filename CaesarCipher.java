import java.util.Scanner;
public class CaesarCipher {
        // Encrypt method
    public static String encrypt(String text, int k) {
        StringBuilder result = new StringBuilder();
        k = k % 26; // Ensure shift is within 0-25
        
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char encryptedChar = (char) ('A' + (c - 'A' + k) % 26);
                result.append(encryptedChar);
            } else if (Character.isLowerCase(c)) {
                char encryptedChar = (char) ('a' + (c - 'a' + k) % 26);
                result.append(encryptedChar);
            } else {
                result.append(c); // Leave non-alphabetic characters unchanged
            }
        }
        return result.toString();
    }

    // Decrypt method
    public static String decrypt(String text, int k) {
        // Decrypting is the same as encrypting with a negative shift
        return encrypt(text, 26 - (k % 26));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int k = scanner.nextInt();

        // Encryption
        String encryptedText = encrypt(text, k);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decryption
        String decryptedText = decrypt(encryptedText, k);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}