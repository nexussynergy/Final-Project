import java.util.*;
import java.text.DecimalFormat;

public class questionaires {
    Scanner in = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.00");
    public int choice = 0;
    // 0 - unidentified
    // 1 - true
    // 2 - false
    String currencyCode[] = { "USD", "EUR", "INR", "JPY", "PHP" };
    int currencyplaceholder;
    boolean error = false;
    boolean incomecon = true;
    double income;
    double housingUtilities = 0;
    double housingLivingCost = 0;
    double groceriesExpenses = 0;
    double transportationExpenses = 0;
    double healthCare = 0;
    double personalSpendingExpenses = 0;
    double debtPayments = 0;
    double savingsExpense = 0;
    double taxDeduct = 0;
    double childExpense = 0;
    double totalExpenses = 0;

    public void heading() {
        System.out.println("LOGISTICS - MONTHLY EXPENSE TRACKER");
        System.out.println("-----------------------------------\n");
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print('\u000C');
    }

    public void welcomeMessage() {
        System.out.println(
                "Good Day. This program will help you track your monthly expenses based on your income/salary.");
        System.out.print("To continue please, enter:\n\n1. Continue\n2. Exit");
        if (!error) {
            System.out.print("\nChoice: ");
        } else {
            System.out.print("\nChoose the correct syntax: ");
        }
        choice = in.nextInt();
    }

    public void currencyPreference() {
        System.out.println(
                "Which of these currencies do you prefer to use when transacting? Please choose from the options below.\n");
        System.out.println(
                "1. United States Dollar (USD)\n2. European Euro (EUR)\n3. Indian Rupee (INR)\n4. Japanese Yen (JPY)\n5. Philippine Peso (PHP)");
        if (!error) {
            System.out.print("\nPreferred Currency: ");
        } else {
            System.out.print("\nChoose the correct syntax: ");
        }
        choice = in.nextInt();
    }

    public void income() {
        if (incomecon) {
            System.out.println("Preferred Currency: " + currencyCode[currencyplaceholder]);
        }
        System.out.print("Input your income per month: ");
        income = in.nextDouble();
    }

    public void incomeConfirmation() {
        if(income <= 0 || income >= 999000000){
            while(income <= 0 || income >= 999000000){
                clear();
                heading();
                if(income <= 0){
                    System.out.println("I'm sorry user, the income cannot be negative or zero!");
                }
                else if(income >= 999000000){
                    System.out.println("I'm sorry user, the income must not exceed 999 million.");
                }
                
                System.out.print("Please input your income per month again: ");
                income = in.nextDouble();
            }
        }
        System.out.println("Please confirm if your income per month is " + df.format(income) + " " + currencyCode[currencyplaceholder] + ".");
        
        System.out.print("To continue please, enter:\n\n1. Confirm\n2. Rewrite");
        if (!error) {
            System.out.print("\nConfirm Input: ");
        } else {
            System.out.print("\nChoose the correct syntax: ");
        }
        choice = in.nextInt();
    }

    public void surveyTermsAndConditions() {
        choice = 0;
        System.out.println(
                "The program will ask you questions about your spending habits to track your monthly expenses.\nThis will help you see where your money is going and identify potential areas for savings\nYou'll be asked specific questions for each expense category, such as how much you spend and if you have recurring bills.\nAnswer accurately for the most helpful insights.");
        System.out.println("\nDo you agree to this terms and conditions?");
        System.out.print("1. Agree\n2. Disagree");
        if (!error) {
            System.out.print("\nYour answer: ");
        } else {
            System.out.print("\nChoose the correct syntax: ");
        }
        choice = in.nextInt();
    }

    public void expenseSurvey() {

        choice = 0;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you rent or own a unit?\n1. Rent\n2. Own");
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            choice = in.nextInt();
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }

        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay for rent every month?");
            System.out.print("\nYour answer: ");
            housingUtilities += in.nextDouble();
        }

        clear();
        heading();
        System.out.println("What is your monthly utility bill (electricity, water, gas, etc.)?");
        System.out.print("\nYour answer: ");
        housingUtilities += in.nextDouble();

        clear();
        heading();
        System.out.println("How much do you spend on home maintenance and repairs?");
        System.out.print("\nYour answer: ");
        housingLivingCost += in.nextDouble();

        clear();
        heading();
        System.out.println("What is your monthly cost for internet?");
        System.out.print("\nYour answer: ");
        housingLivingCost += in.nextDouble();

        clear();
        heading();
        System.out.println("How much do you spend on groceries every month?");
        System.out.print("\nYour answer: ");
        groceriesExpenses += in.nextDouble(); 

        choice = 0;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have Car?\n1. Yes\n2. No");
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            choice = in.nextInt();
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }

        clear();
        heading();
        if (choice == 1) {
            System.out.println("What is your monthly car payment?");
            System.out.print("\nYour answer: ");
            transportationExpenses += in.nextDouble();
            System.out.println("How much do you spend on gas every month?");
            System.out.print("\nYour answer: ");
            transportationExpenses += in.nextDouble();
        } else {
            System.out.println("Do you use public transportation, and if so, what is your monthly cost?");
            System.out.print("\nYour answer: ");
            transportationExpenses += in.nextDouble();
        }
        clear();
        heading();
        

        choice = 0;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have any monthly medical expenses (such as prescription medication, doctor visits, etc.)?\n1. Yes\n2. No");
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            choice = in.nextInt();
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }

        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay for health expenses every month?");
            System.out.print("\nYour answer: ");
            healthCare += in.nextDouble();
        }

        clear();
        heading();
        System.out.println("How much do you typically spend on personal items (clothing, grooming, etc.) each month?");
        System.out.print("\nYour answer: ");
        personalSpendingExpenses += in.nextDouble();

        clear();
        heading();
        System.out.println("How much do you typically spend on eating out and entertainment each month?");
        System.out.print("\nYour answer: ");
        personalSpendingExpenses += in.nextDouble();

        choice = 0;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have debt?\n1. Yes\n2. No");
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            choice = in.nextInt();
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }

        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay towards any outstanding debts each month (such as credit card payments, student loans, etc.)?");
            System.out.print("\nYour answer: ");
            debtPayments += in.nextDouble();
        }

        clear();
        heading();
        System.out.println("How much do you set aside each month for savings?");
        System.out.print("\nYour answer: ");
        savingsExpense += in.nextDouble();

        
        clear();
        heading();
        System.out.println("What is your estimated monthly tax payment or deduction (If not applicable please enter 0)");
        System.out.print("\nYour answer: ");
        taxDeduct += in.nextDouble();

        choice = 0;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have a child? \n1. Yes\n2. No");
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            choice = in.nextInt();
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }

        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you spend on child care and school tuition each month?");
            System.out.print("\nYour answer: ");
            childExpense += in.nextDouble();
        }
    }

    public int currencyPlaceholder(){
        return currencyplaceholder;
    }

    public double getInc(){
        return income;
    }
    public double gethousingutil(){
        return housingUtilities;
    }
    public double getHousingLivCost(){
        return housingLivingCost;
    }
    public double getGroceries(){
        return groceriesExpenses;
    }
    public double getTranspo(){
        return transportationExpenses;
    }
    public double getHealthcare(){
        return healthCare;
    }
    public double getPersonalSpend(){
        return personalSpendingExpenses;
    }
    public double getDebtpayments(){
        return debtPayments;
    }
    public double getSavingsExpense(){
        return savingsExpense;
    }
    public double gettaxDeduct(){
        return taxDeduct;
    }
    public double getChildExpense(){
        return childExpense;
    }
    public double getTotalExpenses(){
        return housingUtilities + housingLivingCost + groceriesExpenses + transportationExpenses + healthCare + personalSpendingExpenses + debtPayments + savingsExpense + taxDeduct + childExpense;
    }
    public double getRemBal(){
        return income - getTotalExpenses();
    }
}
