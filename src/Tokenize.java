import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tokenize {

    public static void main(String[] args) {
        // Get the bank account number to be tokenized
        String bankAccountNumber = "1234567890";

        // Use the MD5 hash algorithm to generate a token for the bank account number
        String token = generateToken(bankAccountNumber);

        // Print the token
        System.out.println("Token: " + token);
    }

    public static String generateToken(String bankAccountNumber) {
        try {
            // Create a MessageDigest object for the MD5 algorithm
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // Update the message digest with the bank account number
            messageDigest.update(bankAccountNumber.getBytes());

            // Generate the token by completing the hash computation
            byte[] token = messageDigest.digest();

            // Convert the token to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : token) {
                sb.append(String.format("%02x", b));
            }

            // Return the token as a hexadecimal string
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
