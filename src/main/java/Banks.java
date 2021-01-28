public class Banks {

    public static void main(String[] args){
        Person person = new Lecturer("Mr","Derek", "Somerville");
        System.out.println(person.toString());
        SavingAccount bankAccountOne = new SavingAccount(person,5.0);
        BankAccount bankAccountTwo = new BankAccount(person);
        bankAccountOne.deposit(50.0);
        bankAccountOne.transFerFunds(45,bankAccountTwo);
        System.out.println(bankAccountOne.toString());
        System.out.println(bankAccountTwo.toString());
        System.out.println("Apply Interest");
        bankAccountOne.applyInterest();
        System.out.println(bankAccountOne.toString());
    }

}
