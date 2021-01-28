public class CurrentAccount extends BankAccount {

    CurrentAccount(Person person){
        super(person);
    }

    public boolean withdraw(double amount){
        this.balance -= amount;
        return true;
    }

    public boolean applyInterest(){
        return false;
    }


}
