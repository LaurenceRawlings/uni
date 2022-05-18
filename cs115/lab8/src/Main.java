import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<BankAccount> bankAccounts = new HashSet<>();

        bankAccounts.add(new BankAccount(123000, 321000));
        bankAccounts.add(new BankAccount(555000, 555000));
        bankAccounts.add(new BankAccount(123000, 321000));

        for (BankAccount account : bankAccounts) {
            System.out.println(String.format("Account Number: %d, Sort Code: %d",
                    account.getAccountNumber(), account.getSortCode()));
        }
    }
}
