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

    protected BankAccount createAccount(String[] rawAccount){
        return createAccount(createPerson(rawAccount), getInterestRate(rawAccount));
    }

    protected double getInterestRate(String[] rawAccount){
        double interestRate = 0.0;
        if (rawAccount.length == 4) {
            interestRate = Double.parseDouble(rawAccount[3]);
        }
        return interestRate;
    }

    protected Person createPerson(String[] rawAccount){
        return new Person(rawAccount[Person.titleCol],rawAccount[Person.firstNameCol],rawAccount[Person.lastNameCol]);
    }

    protected List<String[]> removeHeader(List<String[]> rawAccounts){
        String[] header = rawAccounts.remove(0);
        return rawAccounts;
    }

    protected void loadAccounts(List<String[]> rawAccounts){
        rawAccounts = removeHeader(rawAccounts);
        for (String[] rawAccount: rawAccounts) {
            accounts.add(createAccount(rawAccount));
        }
    }

    protected void loadAccounts(){
        List<String[]> rawAccounts = csvLoader.getData("accounts.csv");
        loadAccounts(rawAccounts);
    }

    protected String createNewLineMessage(String existingMessage, String newMessage){
        if (existingMessage == "") {
            existingMessage = newMessage;
        } else {
            existingMessage += System.lineSeparator() + newMessage;
        }
        return existingMessage;
    }

    protected String displayAccounts(List<BankAccount> accounts){
        String accountDetails = "";
        for (BankAccount account : accounts){
            accountDetails = createNewLineMessage(accountDetails, account.toString());
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
