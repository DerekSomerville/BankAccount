import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<BankAccount>();
    private CSVLoader csvLoader = new CSVLoader();

    private BankAccount createAccount(Person person, double interestRate) {
        BankAccount account;
        if (interestRate > 0){
            account = new SavingAccount(person,interestRate);
        } else {
            account = new CurrentAccount(person);
        }
        return account;
    }

    private double getInterestRate(String[] rawAccount){
        double interestRate = 0.0;
        if (rawAccount.length == 4) {
            interestRate = Double.parseDouble(rawAccount[3]);
        }
        return interestRate;
    }

    private void loadAccounts(){
        List<String[]> rawAccounts = csvLoader.getData("accounts.csv");
        String[] header = rawAccounts.remove(0);
        Person person;
        for (String[] rawAccount: rawAccounts) {
            person = new Person(rawAccount[0],rawAccount[1],rawAccount[2]);
            BankAccount account = createAccount(person, getInterestRate(rawAccount));
            accounts.add(account);
        }
    }

    private void displayAccounts(){
        for (BankAccount account : accounts){
            System.out.println(account.toString());
        }
    }

    private void applyInterest(){
        for (BankAccount account : accounts){
            account.applyInterest();
        }
    }

    public static void main(String[] args){
        Bank bank = new Bank();
        bank.loadAccounts();
        bank.accounts.get(0).deposit(30.0);
        bank.accounts.get(0).transFerFunds(45,bank.accounts.get(1));
        bank.displayAccounts();
        bank.applyInterest();
        bank.displayAccounts();
    }

}
