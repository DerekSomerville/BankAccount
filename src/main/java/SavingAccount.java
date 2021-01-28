public class SavingAccount extends BankAccount {

    private double interestRate;

    public SavingAccount(Person person, double interestRate){
        super(person);
        this.interestRate = interestRate;
    }

    public boolean withdraw(double amount){
        boolean result = false;
        if (getBalance() - amount > 0) {
            result = true;
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
        return result;
    }

    public String toString(){
        return super.toString() + " " +  interestRate;
    }

    public boolean applyInterest(){
        balance += balance * (interestRate/100);
        return true;
    }

}
