//Monthly Expense Tracker - Logistics
import java.text.DecimalFormat;

public class monthlyexpensetracker{
    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat("#.00");
        questionaires q = new questionaires();
        decisions d = new decisions();

        q.clear();
        d.proceed();

        //summary
        q.clear();
        q.heading();
        System.out.println("Your income: " + df.format(d.getInc()));
        System.out.println("Your Housing utilities expenses is: " + df.format(d.gethousingutil()));
        System.out.println("Your Housing living cost is: " + df.format(d.getHousingLivCost()));
        System.out.println("Your Groceries Expense is: " + df.format(d.getGroceries()));
        System.out.println("Your Transportation Expense is: " + df.format(d.getTranspo()));
        System.out.println("Your Healthcare Expense is: " + df.format(d.getHealthcare()));
        System.out.println("Your Personal Spending Expense is: " + df.format(d.getPersonalSpend()));
        System.out.println("Your Debt Payment is: " + df.format(d.getDebtpayments()));
        System.out.println("Your Savings Expense is: " + df.format(d.getSavingsExpense()));
        System.out.println("Your Tax Deduct is: " + df.format(d.gettaxDeduct()));
        System.out.println("Your Child Expense is: " + df.format(d.getChildExpense()));

        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("The total amount of expenses is: " + df.format(d.getTotalExpenses()));
    }
}