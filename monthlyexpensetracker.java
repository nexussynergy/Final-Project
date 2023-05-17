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
        System.out.printf("%-34s | %-10s \n", "Your Housing Utilities Expenses is: " + df.format(d.gethousingutil()) , "| This is " + df.format(d.gethousingutil() / d.getInc() * 100) + "% of your income."); 
        System.out.printf("%-34s | %-10s \n", "Your Housing Living cost is: " +  df.format(d.getHousingLivCost()));
        System.out.printf("%-34s | %-10s \n", "Your Groceries Expense is: " + df.format(d.getGroceries()));
        System.out.printf("%-34s | %-10s \n", "Your Transportation Expense is: " + df.format(d.getTranspo()));
        if(d.getHealthcare() > 0){
            System.out.printf("%-34s | %-10s \n", "Your Healthcare Expense is: " + df.format(d.getHealthcare())); //skippable
        }
        System.out.printf("%-34s | %-10s \n", "Your Personal Spending Expense is: " + df.format(d.getPersonalSpend()));
        if(d.getDebtpayments() > 0){
            System.out.printf("%-34s | %-10s \n", "Your Debt Payment is: " + df.format(d.getDebtpayments())); //skippable
        }
        System.out.printf("%-34s | %-10s \n", "Your Savings Expense is: " + df.format(d.getSavingsExpense()));
        System.out.printf("%-34s | %-10s \n", "Your Tax Deduct is: " + df.format(d.gettaxDeduct()));
        if(d.getChildExpense() > 0){
            System.out.printf("%-34s | %-10s \n", "Your Child Expense is: " + df.format(d.getChildExpense())); //skippable
        }
        System.out.println("--------------------------------------------------------------------------------");

        System.out.printf("%-34s | %-10s \n", "The total amount of expenses is: " + df.format(d.getTotalExpenses()), " " + d.currencyCode[d.currencyPlaceholder()]);
        System.out.printf("%-34s | %-10s \n", "Your remaining balance is: " +  df.format(d.getInc() - d.getTotalExpenses()));
    }

    /* FLAW SHITS
     * if negative ang i input sa user
     * kung 0 ang expense, ug katong daghan na kaayog inputs
     * 
     * 
     * ADDITIONAL INFORMATION
     * text library decimal format
     * text formatting %-10s justify
    */
}