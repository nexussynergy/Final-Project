//Monthly Expense Tracker - Logistics

public class monthlyexpensetracker{
    public static void main(String[] args){
        questionaires q = new questionaires();
        decisions d = new decisions();

        q.startingPrompt();
        q.clear();
        d.proceed();
    }
}