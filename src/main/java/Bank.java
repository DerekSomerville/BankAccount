import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<BankAccount>();
    private CSVLoader csvLoader = new CSVLoader();

    protected BankAccount createAccount(Person person, double interestRate) {
        BankAccount account;
        if (interestRate > 0){
            account = new SavingAccount(person,interestRate);
        } else {
            account = new CurrentAccount(person);
        }
        return account;
    }

    protected double getInterestRate(String[] rawAccount){
        double interestRate = 0.0;
        if (rawAccount.length == 4) {
            interestRate = Double.parseDouble(rawAccount[3]);
        }
        return interestRate;
    }

    protected void loadAccounts(List<String[]> rawAccounts){
        String[] header = rawAccounts.remove(0);
        Person person;
        for (String[] rawAccount: rawAccounts) {
            person = new Person(rawAccount[0],rawAccount[1],rawAccount[2]);
            BankAccount account = createAccount(person, getInterestRate(rawAccount));
            accounts.add(account);
        }
    }

    protected void loadAccounts(){
        List<String[]> rawAccounts = csvLoader.getData("accounts.csv");
        loadAccounts(rawAccounts);
    }

    protected String displayAccounts(List<BankAccount> accounts){
        String accountDetails = "";
        for (BankAccount account : accounts){
            if (accountDetails == "") {
                accountDetails = account.toString();
            } else {
                accountDetails += System.lineSeparator() + account.toString();
            }
        }
        return accountDetails;
    }

    private void displayAccounts(){
        String accountsDetails = displayAccounts(accounts);
        System.out.println(accountsDetails);
    }

    protected void applyInterest(){
        for (BankAccount account : accounts){
            account.applyInterest();
        }
    }

    protected void runAccounts(){
        loadAccounts();
        accounts.get(0).deposit(60.0);
        accounts.get(0).transFerFunds(45,accounts.get(1));
        displayAccounts();
        applyInterest();
        displayAccounts();
    }

    public static void main(String[] args){
        Bank bank = new Bank();
        bank.runAccounts();
    }

}
