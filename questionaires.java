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
    boolean inputmismatch = false;
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
        try {
            choice = in.nextInt();
        } catch (InputMismatchException e) {
            in.nextLine();
            choice = 0;
        }
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
        try {
            choice = in.nextInt();
        } catch (InputMismatchException e) {
            in.nextLine();
            choice = 0;
        }
    }

    public void income() {
        if (incomecon) {
            System.out.println("Preferred Currency: " + currencyCode[currencyplaceholder]);
        }
        if (!inputmismatch) {
            System.out.print("Input your income this month: ");
        } else {
            System.out.println("Program does not accept non-numerical values!");
            System.out.print("Input your income this month: ");
        }

        try {
            inputmismatch = false;
            income = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            income = 0;
            inputmismatch = true;
            clear();
            heading();
            income();
        }
    }

    public void incomeConfirmation() {
        if (income <= 0 || income >= 999000000) {
            while (income <= 0 || income >= 999000000) {
                clear();
                heading();
                if (income <= 0) {
                    System.out.println("I'm sorry user, the income cannot be negative or zero!");
                } else if (inputmismatch == true) {
                    System.out.println("I'm sorry user, you cannot input non-numerical values!");
                } else if (income >= 999000000) {
                    System.out.println("I'm sorry user, the income must not exceed 999 million.");
                }
                System.out.print("Please input your income per month again: ");
                try {
                    inputmismatch = false;
                    income = in.nextDouble();
                } catch (InputMismatchException e) {
                    in.nextLine();
                    income = 0;
                    inputmismatch = true;
                    incomeConfirmation();
                }
            }
        }
        System.out.println("Please confirm if your income per month is " + df.format(income) + " "
                + currencyCode[currencyplaceholder] + ".");

        System.out.print("To continue please, enter:\n\n1. Confirm\n2. Rewrite");
        if (!error) {
            System.out.print("\nConfirm Input: ");
        } else if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
            System.out.print("Choose the correct syntax: ");
        } else {
            System.out.print("\nChoose the correct syntax: ");
        }
        try {
            inputmismatch = false;
            choice = in.nextInt();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            choice = 0;
        }
    }

    public void surveyTermsAndConditions() {
        choice = 0;
        System.out.println(
                "The program will help you see where your money is going and identify potential areas for savings\nYou'll be asked specific questions for each expense category, such as how much you spend and if you have recurring bills.\nAnswer accurately for the most helpful insights.");
        System.out.println("\nDo you agree to this terms and conditions?");
        System.out.print("1. Agree\n2. Disagree");
        if (!error) {
            System.out.print("\nConfirm Input: ");
        } else if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
            System.out.print("Choose the correct syntax: ");
        } else {
            System.out.print("\nChoose the correct syntax: ");
        }
        try {
            inputmismatch = false;
            choice = in.nextInt();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            choice = 0;
        }
    }

    public void question0() {
        choice = 0;
        error = false;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you rent or own a unit?\n1. Rent\n2. Own");
            if (!error) {
                System.out.print("\nConfirm Input: ");
            }
            else if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
                System.out.print("Choose the correct syntax: ");
            }
            else {
                System.out.print("\nChoose the correct syntax: ");
            }
            try{
                inputmismatch = false;
                choice = in.nextInt();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                choice = 0;
            }
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }
    }

    public void question1(){
        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay for rent every month?");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            System.out.print("\nYour answer: ");
            try{
                inputmismatch = false;
                housingUtilities += in.nextDouble();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                housingUtilities = 0;
                question1();
            }
        }
    }
        
    public void question2(){
        clear();
        heading();
        System.out.println("What is your monthly utility bill (electricity, water, gas, etc.)?");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            housingUtilities += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            housingUtilities = 0;
            question2();
        }
    }

    public void question3(){
        clear();
        heading();
        System.out.println("How much do you spend on home maintenance and repairs?");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            housingLivingCost += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            housingLivingCost = 0;
            question3();
        }
    }

    public void question4(){
        clear();
        heading();
        System.out.println("What is your monthly cost for internet?");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            housingLivingCost += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            housingLivingCost = 0;
            question4();
        }
    }

    public void question5(){
        clear();
        heading();
        System.out.println("How much do you spend on groceries every month?");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            groceriesExpenses += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            groceriesExpenses = 0;
            question5();
        }
    }

    public void question6(){
        choice = 0;
        error = false;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have Car?\n1. Yes\n2. No");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            try{
                inputmismatch = false;
                choice = in.nextInt();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                choice = 0;
                question6();
            }
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }
    }

    public void question7(){
        if (choice == 1) {
            int followup = 0;
            while(followup < 2){
                if(followup == 0){
                    clear();
                    heading();
                    System.out.println("What is your monthly car payment?");
                    if(inputmismatch){
                        System.out.println("\nProgram does not accept non-numerical values!");
                    }
                    System.out.print("\nYour answer: ");
                    try{
                        inputmismatch = false;
                        transportationExpenses += in.nextDouble();
                        followup = 1;
                    }
                    catch(InputMismatchException e){
                        in.nextLine();
                        inputmismatch = true;
                        transportationExpenses = 0;
                        followup = 0;
                    }
                }
                else if(followup == 1){
                    clear();
                    heading();
                    System.out.println("How much do you spend on gas every month?");
                    if(inputmismatch){
                        System.out.println("\nProgram does not accept non-numerical values!");
                    }
                    System.out.print("\nYour answer: ");
                    try{
                        inputmismatch = false;
                        transportationExpenses += in.nextDouble();
                        followup = 2;
                    }
                    catch(InputMismatchException e){
                        in.nextLine();
                        inputmismatch = true;
                        transportationExpenses = 0;
                        followup = 1;
                    }
                }
            }  
        } else {
            System.out.println("Do you use public transportation, and if so, what is your monthly cost?");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            System.out.print("\nYour answer: ");
            try{
                inputmismatch = false;
                transportationExpenses += in.nextDouble();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                transportationExpenses = 0;
                question7();
            }
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }
    }

    public void question8(){
        choice = 0;
        error = false;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have any monthly medical expenses (such as prescription medication, doctor visits, etc.)?\n1. Yes\n2. No");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            try{
                inputmismatch = false;
                choice = in.nextInt();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                choice = 0;
                question8();
            }
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }
    }

    public void question9(){
        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay for health expenses every month?");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            System.out.print("\nYour answer: ");
            try{
                inputmismatch = false;
                healthCare += in.nextDouble();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                healthCare = 0;
                question9();
            }
        }
    }
    public void question10(){
        clear();
        heading();
        System.out.println("How much do you typically spend on personal items (clothing, grooming, etc.) each month?");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            personalSpendingExpenses += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            personalSpendingExpenses = 0;
            question10();
        }
    }

    public void question11(){
        clear();
        heading();
        System.out.println("How much do you typically spend on eating out and entertainment each month?");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            personalSpendingExpenses += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            personalSpendingExpenses = 0;
            question11();
        }
    }

    public void question12(){
        choice = 0;
        error = false;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have debt?\n1. Yes\n2. No");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            try{
                inputmismatch = false;
                choice = in.nextInt();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                choice = 0;
                question12();
            }
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }
    }

    public void question13(){
        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay towards any outstanding debts each month (such as credit card payments, student loans, etc.)?");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            System.out.print("\nYour answer: ");
            try{
                inputmismatch = false;
                debtPayments += in.nextDouble();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                debtPayments = 0;
                question13();
            }
        }
    }

    public void question14(){
        clear();
        heading();
        System.out.println("How much do you set aside each month for savings?");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            savingsExpense += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            savingsExpense = 0;
            question14();
        }
    }
        
    public void question15(){
        clear();
        heading();
        System.out.println("What is your estimated monthly tax payment or deduction (If not applicable please enter 0)");
        if(inputmismatch){
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try{
            inputmismatch = false;
            taxDeduct += in.nextDouble();
        }
        catch(InputMismatchException e){
            in.nextLine();
            inputmismatch = true;
            taxDeduct = 0;
            question15();
        }
    }

    public void question16(){
        choice = 0;
        error = false;
        while (choice < 1 || choice > 2) {
            clear();
            heading();
            System.out.println("Do you have a child? \n1. Yes\n2. No");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            try{
                inputmismatch = false;
                choice = in.nextInt();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                choice = 0;
                question16();
            }
            if (choice < 1 || choice > 2) {
                error = true;
            }
        }
    }

    public void question17(){
        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you spend on child care and school tuition each month?");
            if(inputmismatch){
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            System.out.print("\nYour answer: ");
            try{
                inputmismatch = false;
                childExpense += in.nextDouble();
            }
            catch(InputMismatchException e){
                in.nextLine();
                inputmismatch = true;
                childExpense = 0;
                question17();
            }
        }
    }


    public int currencyPlaceholder() {
        return currencyplaceholder;
    }

    public double getInc() {
        return income;
    }

    public double gethousingutil() {
        return housingUtilities;
    }

    public double getHousingLivCost() {
        return housingLivingCost;
    }

    public double getGroceries() {
        return groceriesExpenses;
    }

    public double getTranspo() {
        return transportationExpenses;
    }

    public double getHealthcare() {
        return healthCare;
    }

    public double getPersonalSpend() {
        return personalSpendingExpenses;
    }

    public double getDebtpayments() {
        return debtPayments;
    }

    public double getSavingsExpense() {
        return savingsExpense;
    }

    public double gettaxDeduct() {
        return taxDeduct;
    }

    public double getChildExpense() {
        return childExpense;
    }

    public double getTotalExpenses() {
        return housingUtilities + housingLivingCost + groceriesExpenses + transportationExpenses + healthCare
                + personalSpendingExpenses + debtPayments + taxDeduct + childExpense;
    }

    public double getRemBal() {
        return income - getTotalExpenses();
    }
}
