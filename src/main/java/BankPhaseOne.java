import java.util.ArrayList;
import java.util.List;

public class BankPhaseOne {

    public static void  main(String[] args){
        CSVLoader l = new CSVLoader();

        List<String[]> rd = l.getData("accounts.csv");
        String[] h = rd.remove(0);
        BankAccount a;
        List<BankAccount> s = new ArrayList<BankAccount>();
        for (String[] r : rd){
            Person p = new Person(r[0],r[1],r[2]);
            if (r.length == 4) {
                a = new SavingAccount(p,Double.parseDouble(r[3]));
            } else {
                a = new CurrentAccount(p);
            }
            s.add(a);
        }
        s.get(0).deposit(60);
        s.get(0).transFerFunds(45,s.get(1));
        for (BankAccount b: s){
            System.out.println(b.toString());
        }
        for (BankAccount b: s){
            b.applyInterest();
        }
        for (BankAccount b: s){
            System.out.println(b.toString());
        }

    }
}
