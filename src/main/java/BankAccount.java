public abstract class BankAccount {
    private Person person;
    private int accountNumber;
    protected double balance;
    private static int nextAccountNumber = 0;
    private double interestRate;

    BankAccount(Person person){
        this.person = person;
        this.balance = 0.0;
        this.interestRate = 0.0;
        nextAccountNumber += 1;
        this.accountNumber = nextAccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return person.accountName();
    }

    public String toString(){
        return getName() + " " + accountNumber + " " + balance;
    }

    abstract boolean withdraw(double amount);

    public void deposit(double amount){
        this.balance += amount;
    }

    abstract boolean applyInterest();

    public boolean transFerFunds( double amount, BankAccount toBank){
        boolean result = false;
        if (withdraw(amount)) {
            toBank.deposit(amount);
            result = true;
        }
        return result;
    }
}
