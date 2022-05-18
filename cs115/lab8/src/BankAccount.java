public class BankAccount {
    private int accountNumber;
    private int sortCode;

    public BankAccount(int accountNumber, int sortCode) {
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        BankAccount other = (BankAccount)obj;
        if (accountNumber == other.getAccountNumber() && sortCode == other.getSortCode()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (sortCode * 3) + (accountNumber * 5);
    }
}
