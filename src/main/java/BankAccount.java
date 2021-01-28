public class BankAccount {

    private Person person;
    private int accountNumber;
    protected double balance;
    private static int nextAccountNumber = 0;

    BankAccount(Person person){
        this.person = person;
        this.balance = 0.0;
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

    public boolean withdraw(double amount){
        this.balance -= amount;
        return true;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void transFerFunds( double amount, BankAccount toBank){
        if (withdraw(amount)) {
            toBank.deposit(amount);
        }
    }
}
