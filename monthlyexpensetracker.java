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
        System.out.printf("%-50s | %-10s \n", "Housing Utilities Expenses is: " + df.format(d.gethousingutil()) , "This is " + df.format(d.gethousingutil() / d.getInc() * 100) + "% of your income."); 
        System.out.printf("%-50s | %-10s \n", "Housing Living cost is: " +  df.format(d.getHousingLivCost()), "This is " + df.format(d.getHousingLivCost() / d.getInc() * 100) + "% of your income.");
        System.out.printf("%-50s | %-10s \n", "Groceries Expense is: " + df.format(d.getGroceries()), "This is " + df.format(d.getGroceries() / d.getInc() * 100) + "% of your income.");
        System.out.printf("%-50s | %-10s \n", "Transportation Expense is: " + df.format(d.getTranspo()), "This is " + df.format(d.getTranspo() / d.getInc() * 100) + "% of your income.");
        if(d.getHealthcare() > 0){
            System.out.printf("%-50s | %-10s \n", "Healthcare Expense is: " + df.format(d.getHealthcare()), "This is " + df.format(d.getHealthcare() / d.getInc() * 100) + "% of your income."); 
        }
        System.out.printf("%-50s | %-10s \n", "Personal Spending Expense is: " + df.format(d.getPersonalSpend()), "This is " + df.format(d.getPersonalSpend() / d.getInc() * 100) + "% of your income.");
        if(d.getDebtpayments() > 0){
            System.out.printf("%-50s | %-10s \n", "Debt Payment is: " + df.format(d.getDebtpayments()), "This is " + df.format(d.getDebtpayments() / d.getInc() * 100) + "% of your income."); //skippable
        }
        System.out.printf("%-50s | %-10s \n", "Savings Expense is: " + df.format(d.getSavingsExpense()), "This is " + df.format(d.getSavingsExpense() / d.getInc() * 100) + "% of your income.");
        System.out.printf("%-50s | %-10s \n", "Tax Deduct is: " + df.format(d.gettaxDeduct()), "This is " + df.format(d.gettaxDeduct() / d.getInc() * 100) + "% of your income.");
        if(d.getChildExpense() > 0){
            System.out.printf("%-50s | %-10s \n", "Child Expense is: " + df.format(d.getChildExpense()), "This is " + df.format(d.getChildExpense() / d.getInc() * 100) + "% of your income."); //skippable
        }
        System.out.println("--------------------------------------------------------------------------------");

        System.out.printf("%-50s | %-10s \n", "The total amount of expenses is: " + df.format(d.getTotalExpenses()) +  " " + d.currencyCode[d.currencyPlaceholder()], "This is " + df.format(d.getTotalExpenses() / d.getInc() * 100) + "% of your income.");
        System.out.printf("%-50s | %-10s \n", "Your remaining balance is: " +  df.format(d.getInc() - d.getTotalExpenses()) , "This is " + df.format(d.getRemBal() / d.getInc() * 100) + "% of your income.");
    }

    /* FLAW SHITS
     * if negative ang i input sa user
     * kung 0 ang expense, ug katong daghan na kaayog inputs
     * determined limit "12311231231312312"
     *
     * ADDITIONAL INFORMATION
     * text library decimal format
     * text formatting %-10s justify
    */
}