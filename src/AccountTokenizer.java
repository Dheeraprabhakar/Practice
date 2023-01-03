import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
class Account{
    String accountId;
    boolean isSensitive;
    Account(String accountId, boolean isSensitive){
        this.accountId = accountId;
        this.isSensitive=isSensitive;
    }
}
public class AccountTokenizer {

    public static void main(String args[]){
        AccountTokenizer acc = new AccountTokenizer();
        acc.process();

    }
//180e3158-be79-4460-9092-04c62b52b306
//f37187b7-4de5-41ba-860b-4067a636ca76
    private void process() {
        Account a1=new Account("12345", false);
        Account a2=new Account("11345", true);
        Account a3=new Account("13345", true);
        List<Account> l = new ArrayList<>();
        l.add(a1);
        l.add(a2);
        l.add(a3);
        tokenize(l);

        for(Account acc:l) {
            System.out.println(acc.accountId);
        }

    }

    private void tokenize(List<Account> l) {
        for(Account acc: l){
            if(acc.isSensitive){
                acc.accountId = generateToken(acc.accountId);
            }
        }
    }
//997ddfb43e587b1580a0caba67f9de24
        public String generateToken(String bankAccountNumber) {
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
