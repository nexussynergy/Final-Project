
//Monthly Expense Tracker - Logistics
import java.text.DecimalFormat;
import java.util.Scanner;

public class monthlyexpensetracker {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat z = new DecimalFormat("0.##");
        Scanner in = new Scanner(System.in);
        questionnaires q = new questionnaires();
        decisions d = new decisions();

        q.clear();
        d.proceed();

        // summary
        q.clear();
        q.heading();

        System.out.println("                                                 CREDIT");
        System.out.println("Your income: " + df.format(d.getInc()) + " " + d.currencyCode[d.currencyPlaceholder()]);
        if (d.getSavingsExpense() >= 0 && d.getSavingsExpense() < 1) {
            System.out.printf("%-50s | %-10s \n",
                    "Savings: " + z.format(d.getSavingsExpense()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + z.format(d.getSavingsExpense() / d.getInc() * 100) + "% of your income");
        } else {
            System.out.printf("%-50s | %-10s \n",
                    "Savings: " + df.format(d.getSavingsExpense()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + df.format(d.getSavingsExpense() / d.getInc() * 100) + "% of your income");
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                                                 DEBIT");

        if (d.gethousingutil() >= 0 && d.gethousingutil() < 1) {
            System.out.printf("%-50s | %-10s \n",
                    "Housing Utilities Expenses is: " + z.format(d.gethousingutil()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + z.format(d.gethousingutil() / d.getInc() * 100) + "% of your income");
        } else {
            System.out.printf("%-50s | %-10s \n",
                    "Housing Utilities Expenses is: " + df.format(d.gethousingutil()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + df.format(d.gethousingutil() / d.getInc() * 100) + "% of your income");
        }
        if (d.getHousingLivCost() >= 0 && d.getHousingLivCost() < 1) {
            System.out.printf("%-50s | %-10s \n",
                    "Housing Living cost is: " + z.format(d.getHousingLivCost()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + z.format(d.getHousingLivCost() / d.getInc() * 100) + "% of your income");
        } else {
            System.out.printf("%-50s | %-10s \n",
                    "Housing Living cost is: " + df.format(d.getHousingLivCost()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + df.format(d.getHousingLivCost() / d.getInc() * 100) + "% of your income");
        }
        if (d.getGroceries() >= 0 && d.getGroceries() < 1) {
            System.out.printf("%-50s | %-10s \n",
                    "Groceries Expenses is: " + z.format(d.getGroceries()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + z.format(d.getGroceries() / d.getInc() * 100) + "% of your income");
        } else {
            System.out.printf("%-50s | %-10s \n",
                    "Groceries Expense is: " + df.format(d.getGroceries()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + df.format(d.getGroceries() / d.getInc() * 100) + "% of your income");
        }
        if (d.getTranspo() >= 0 && d.getTranspo() < 1) {
            System.out.printf("%-50s | %-10s \n",
                    "Transportation Expense is: " + z.format(d.getTranspo()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + z.format(d.getTranspo() / d.getInc() * 100) + "% of your income");
        } else {
            System.out.printf("%-50s | %-10s \n",
                    "Transportation Expense is: " + df.format(d.getTranspo()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + df.format(d.getTranspo() / d.getInc() * 100) + "% of your income");
        }

        if (d.getHealthcare() > 0) {
            if (d.getHealthcare() < 1) {
                System.out.printf("%-50s | %-10s \n",
                        "Healthcare Expense is: " + z.format(d.getHealthcare()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + z.format(d.getHealthcare() / d.getInc() * 100) + "% of your income");
            } else {
                System.out.printf("%-50s | %-10s \n",
                        "Healthcare Expense is: " + df.format(d.getHealthcare()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + df.format(d.getHealthcare() / d.getInc() * 100) + "% of your income");
            }
        }

        if (d.getPersonalSpend() >= 0 && d.getPersonalSpend() < 1) {
            System.out.printf("%-50s | %-10s \n",
                    "Personal Spending Expense is: " + z.format(d.getPersonalSpend()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + z.format(d.getPersonalSpend() / d.getInc() * 100) + "% of your income");
        } else
            System.out.printf("%-50s | %-10s \n",
                    "Personal Spending Expense is: " + df.format(d.getPersonalSpend()) + " "
                            + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + df.format(d.getPersonalSpend() / d.getInc() * 100) + "% of your income");

        if (d.getDebtpayments() > 0) {
            if (d.getDebtpayments() < 1) {
                System.out.printf("%-50s | %-10s \n",
                        "Debt Payment is: " + z.format(d.getDebtpayments()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + z.format(d.getDebtpayments() / d.getInc() * 100) + "% of your income");
            } else {
                System.out.printf("%-50s | %-10s \n",
                        "Debt Payment is: " + df.format(d.getDebtpayments()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + df.format(d.getDebtpayments() / d.getInc() * 100) + "% of your income");
            }
        }
        if (d.gettaxDeduct() >= 0 && d.gettaxDeduct() < 1) {
            System.out.printf("%-50s | %-10s \n",
                    "Tax Deduct is: " + z.format(d.gettaxDeduct()) + " " + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + z.format(d.gettaxDeduct() / d.getInc() * 100) + "% of your income");
        } else {
            System.out.printf("%-50s | %-10s \n",
                    "Tax Deduct is: " + df.format(d.gettaxDeduct()) + " " + d.currencyCode[d.currencyPlaceholder()],
                    "This is " + df.format(d.gettaxDeduct() / d.getInc() * 100) + "% of your income");
        }

        if (d.getChildExpense() > 0) {
            if (d.getChildExpense() < 1) {
                System.out.printf("%-50s | %-10s \n",
                        "Child Expense is: " + z.format(d.getChildExpense()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + z.format(d.getChildExpense() / d.getInc() * 100) + "% of your income");
            } else {
                System.out.printf("%-50s | %-10s \n",
                        "Child Expense is: " + df.format(d.getChildExpense()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + df.format(d.getChildExpense() / d.getInc() * 100) + "% of your income");
            }
        }

        System.out.println("--------------------------------------------------------------------------------");

        System.out.printf("%-50s | %-10s \n",
                "The total amount of expenses is: " + df.format(d.getTotalExpenses()) + " "
                        + d.currencyCode[d.currencyPlaceholder()],
                "This is " + df.format(d.getTotalExpenses() / d.getInc() * 100) + "% of your income");

        if (d.getTotalExpenses() < d.getInc()) {
            if ((d.getInc() - d.getTotalExpenses()) >= 0 || (d.getInc() - d.getTotalExpenses() < 1)) {
                System.out.printf("%-50s | %-10s \n",
                        "Your remaining balance is: "
                                + z.format(d.getInc() - d.getTotalExpenses()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + z.format(d.getRemBal() / d.getInc() * 100) + "% of your income");
            } else {
                System.out.printf("%-50s | %-10s \n",
                        "Your remaining balance is: "
                                + df.format(d.getInc() - d.getTotalExpenses()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + df.format(d.getRemBal() / d.getInc() * 100) + "% of your income");
            }

        } else {
            if ((d.getTotalExpenses() - d.getInc()) >= 0 && ((d.getTotalExpenses() - d.getInc()) < 1)) {
                System.out.printf("%-50s | %-10s \n",
                        "Your exceeding balance is: "
                                + z.format(d.getTotalExpenses() - d.getInc()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + z.format((d.getRemBal() / d.getInc() * 100) * -1) + "% of your income");
            } else {
                System.out.printf("%-50s | %-10s \n",
                        "Your exceeding balance is: "
                                + df.format(d.getTotalExpenses() - d.getInc()) + " "
                                + d.currencyCode[d.currencyPlaceholder()],
                        "This is " + df.format((d.getRemBal() / d.getInc() * 100) * -1) + "% of your income");
            }
        }

        if (d.getTotalExpenses() < d.getInc()) {
            System.out.println("I am proud of you for staying on budget and saving money this month.");
        } else {
            System.out.println("You have insufficient funds, please save more in order to meet the budget for the next month.");
        }
        in.close();
    }
}