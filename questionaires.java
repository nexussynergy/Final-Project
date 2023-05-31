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
    int count = 0;
    int followup = 0;
    boolean error = false;
    boolean incomecon = true;
    boolean inputmismatch = false;
    double temporaryinput;
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
        count = 0;
        clear();
        heading();
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
        count = 1;
    }

    public void currencyPreference() {
        count = 1;
        clear();
        heading();
        System.out.println(
                "Which of these currencies do you prefer to use when transacting? Please choose from the options below.\n");
        System.out.println(
                "1. United States Dollar (USD)\n2. European Euro (EUR)\n3. Indian Rupee (INR)\n4. Japanese Yen (JPY)\n5. Philippine Peso (PHP)\n6. Back");
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
        count = 2;
    }

    public void income() {
        count = 2;
        clear();
        heading();
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
        count = 3;
    }

    public void incomeConfirmation() {
        count = 3;
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

        System.out.print("To continue please, enter:\n\n1. Confirm\n2. Rewrite\n3. Back");
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
        count = 4;
    }

    public void surveyTermsAndConditions() {
        count = 4;
        choice = 0;
        clear();
        heading();
        System.out.println(
                "You'll be asked specific questions for each expense category, such as how much you spend for entertainment, child care, and if you have bills this month.\nAnswer accurately for the most helpful insights.");
        System.out.println("\nDo you agree to this terms and conditions?");
        System.out.print("1. Agree\n2. Disagree\n3. Back");
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
        count = 5;
    }

    public void question0() {
        count = 5;
        choice = 0;
        error = false;
        while (choice < 1 || choice > 3) {
            clear();
            heading();
            System.out.println("Do you rent or own a unit?\n1. Rent\n2. Own\n3. Back");
            if (!error) {
                System.out.print("\nConfirm Input: ");
            } else if (inputmismatch && error) {
                System.out.println("\nProgram does not accept non-numerical values!");
                System.out.print("Choose the correct syntax: ");
            } else if (error) {
                System.out.print("\nChoose the correct syntax: ");
            }
            try {
                inputmismatch = false;
                choice = in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
                inputmismatch = true;
                error = true;
                choice = 0;
            }
            if (choice < 1 || choice > 3) {
                error = true;
            }

            if (choice == 3) {
                error = false;
                count = 4;
            } else if (choice == 1 || choice == 2) {
                count = 6;
                error = false;
            }
        }
    }

    public void question1() {
        count = 6;
        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay for rent this month?\n-1. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            } else if (error) {
                System.out.println("\nPlease enter a positive value! Only -1 is accepted");
            }
            System.out.print("\nYour answer: ");
            try {
                inputmismatch = false;
                temporaryinput = in.nextDouble();
            } catch (InputMismatchException e) {
                in.nextLine();
                inputmismatch = true;
                temporaryinput = 0;
                question1();
            }

            if (temporaryinput == -1) {
                count = 5;
                error = false;
            } else if (temporaryinput >= 0) {
                housingUtilities += temporaryinput;
                error = false;
                temporaryinput = 0;
                count = 7;
            } else if (temporaryinput < -1) {
                error = true;
            }
        }
    }

    public void question2() {
        count = 7;
        clear();
        heading();
        System.out.println("What is your utility bill this month (electricity, water, gas, etc.)?\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        } else if (error) {
            System.out.println("\nPlease enter a positive value! Only -1 is accepted");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question2();
        }

        if (temporaryinput == -1) {
            count = 6;
            error = false;
        } else if (temporaryinput >= 0) {
            housingUtilities += temporaryinput;
            error = false;
            temporaryinput = 0;
            count = 8;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question3() {
        count = 8;
        clear();
        heading();
        System.out.println("How much do you spend on home maintenance and repairs?\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        } else if (error) {
            System.out.println("\nPlease enter a positive value! Only -1 is accepted");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question3();
        }

        if (temporaryinput == -1) {
            count = 7;
            error = false;
        } else if (temporaryinput >= 0) {
            housingLivingCost += temporaryinput;
            error = false;
            temporaryinput = 0;
            count = 9;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question4() {
        count = 9;
        clear();
        heading();
        System.out.println("What is your internet cost for this month?\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        } else if (error) {
            System.out.println("\nPlease enter a positive value! Only -1 is accepted");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question4();
        }

        if (temporaryinput == -1) {
            count = 8;
            error = false;
        } else if (temporaryinput >= 0) {
            housingLivingCost += temporaryinput;
            error = false;
            temporaryinput = 0;
            count = 10;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question5() {
        count = 10;
        clear();
        heading();
        System.out.println("How much do you spend on groceries this month?\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        } else if (error) {
            System.out.println("\nPlease enter a positive value! Only -1 is accepted");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question5(); // ilisdan
        }

        if (temporaryinput == -1) {
            count = 9; // ilisdan
            error = false;
        } else if (temporaryinput >= 0) {
            groceriesExpenses += temporaryinput; // ilisdan
            error = false;
            temporaryinput = 0;
            count = 11;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question6() {
        count = 11;
        choice = 0;
        error = false;
        while (choice < 1 || choice > 3) {
            clear();
            heading();
            System.out.println("Do you have Car?\n1. Yes\n2. No\n3. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
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
                question6();
            }
            if (choice < 1 || choice > 3) {
                error = true;
            }

            if (choice == 3) {
                error = false;
                count = 10;
            } else if (choice == 1 || choice == 2) {
                count = 12;
            }
        }
        followup = 0;
    }

    public void question7() {
        count = 12;
        if (choice == 1) {
            if (followup > -1 && followup < 2) {
                if (followup == 0) {
                    clear();
                    heading();
                    System.out.println("How much is your car payment this month?\n-1. Back");
                    if (inputmismatch) {
                        System.out.println("\nProgram does not accept non-numerical values!");
                    } else if (!inputmismatch && error) {
                        System.out.println("\nPlease enter a positive value! Only -1 is accepted");
                    }
                    System.out.print("\nYour answer: ");
                    try {
                        inputmismatch = false;
                        temporaryinput = in.nextDouble();
                    } catch (InputMismatchException e) {
                        in.nextLine();
                        inputmismatch = true;
                        temporaryinput = 0; // for error
                        followup = 0;
                        question7();
                    }

                    if (temporaryinput == -1) {
                        count = 11; // ilisdan
                        followup = 0;
                        error = false;
                    } else if (temporaryinput >= 0) {
                        transportationExpenses += temporaryinput; // ilisdan
                        error = false;
                        followup = 1;
                        temporaryinput = 0;
                    } else if (temporaryinput < -1) {
                        error = true;
                    }

                } else if (followup == 1) {
                    clear();
                    heading();
                    System.out.println("How much do you spend on gas this current month?\n-1. Back");
                    if (inputmismatch) {
                        System.out.println("\nProgram does not accept non-numerical values!");
                    } else if (error) {
                        System.out.println("\nPlease enter a positive value! Only -1 is accepted");
                    }
                    System.out.print("\nYour answer: ");
                    try {
                        inputmismatch = false;
                        followup = 2;
                        temporaryinput = in.nextDouble();
                    } catch (InputMismatchException e) {
                        in.nextLine();
                        inputmismatch = true;
                        temporaryinput = 0;
                        followup = 1;
                        question7(); // ilisdan
                    }

                    if (temporaryinput == -1) {
                        count = 12; // ilisdan
                        followup = 0;
                        error = false;
                    } else if (temporaryinput >= 0) {
                        transportationExpenses += temporaryinput; // ilisdan
                        error = false;
                        followup = 2;
                        count = 13;
                        temporaryinput = 1;
                    } else if (temporaryinput < -1) {
                        error = true;
                    }
                }
            }
        } else {
            clear();
            heading();
            System.out.println("Do you use public transportation, and if so, what is your cost this month?\n-1. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            } else if (error) {
                System.out.println("\nPlease enter a positive value! Only -1 is accepted");
            }
            System.out.print("\nYour answer: ");
            try {
                inputmismatch = false;
                temporaryinput = in.nextDouble();
            } catch (InputMismatchException e) {
                in.nextLine();
                inputmismatch = true;
                temporaryinput = 0;
                choice = 0;
                question7(); // ilisdan
            }

            if (temporaryinput == -1) {
                followup = 0;
                count = 11; // ilisdan
                error = false;
            } else if (temporaryinput >= 0) {
                transportationExpenses += temporaryinput; // ilisdan
                error = false;
                temporaryinput = 0;
                count = 13;
            } else if (temporaryinput < -1) {
                error = true;
            }
        }
    }

    public void question8() {
        count = 13;
        choice = 0;
        error = false;
        if (choice < 1 || choice > 3) {
            clear();
            heading();
            System.out.println(
                    "Do you have any monthly medical expenses (such as prescription medication, doctor visits, etc.)?\n1. Yes\n2. No\n3. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
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
                question8();
            }
            if (choice < 1 || choice > 3) {
                error = true;
            }

            if (choice == 3) {
                error = false;
                if (temporaryinput == 1) {
                    choice = 1;
                    followup = 1;
                } else {
                    choice = 2;
                }
                count = 12;
            } else if (choice == 1) {
                count = 14;
                temporaryinput = 1;
            } else if (choice == 2) {
                count = 15;
                temporaryinput = 0;
            }
        }
    }

    public void question9() {
        count = 14;
        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you pay for health expenses this month?\n-1. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            } else if (error) {
                System.out.println("\nPlease enter a positive value! Only -1 is accepted");
            }
            System.out.print("\nYour answer: ");
            try {
                inputmismatch = false;
                temporaryinput = in.nextDouble();
            } catch (InputMismatchException e) {
                in.nextLine();
                inputmismatch = true;
                temporaryinput = 0;
                question9(); // ilisdan
            }

            if (temporaryinput == -1) {
                count = 13; // ilisdan
                choice = 0;
                error = false;
            } else if (temporaryinput >= 0) {
                healthCare += temporaryinput; // ilisdan
                error = false;
                temporaryinput = 0;
                count = 15;
            } else if (temporaryinput < -1) {
                error = true;
            }
        }
        choice = 1;
    }

    public void question10() {
        count = 15;
        clear();
        heading();
        System.out.println(
                "How much do you typically spend on personal items (clothing, grooming, etc.) this month?\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        } else if (error) {
            System.out.println("\nPlease enter a positive value! Only -1 is accepted");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question10(); // ilisdan
        }

        if (temporaryinput == -1) {
            if (choice == 1) {
                count = 14;
            } else {
                count = 13;
            }
            error = false;
        } else if (temporaryinput >= 0) {
            personalSpendingExpenses += temporaryinput; // ilisdan
            error = false;
            temporaryinput = 0;
            count = 16;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question11() {
        count = 16;
        clear();
        heading();
        System.out.println("How much do you spend on eating out and entertainment this month?\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        } else if (error) {
            System.out.println("\nPlease enter a positive value! Only -1 is accepted");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question11(); // ilisdan
        }

        if (temporaryinput == -1) {
            count = 15; // ilisdan
            error = false;
        } else if (temporaryinput >= 0) {
            personalSpendingExpenses += temporaryinput; // ilisdan
            error = false;
            temporaryinput = 0;
            count = 17;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question12() {
        count = 17;
        choice = 0;
        error = false;
        if (choice < 1 || choice > 3) {
            clear();
            heading();
            System.out.println("Do you have debt?\n1. Yes\n2. No\n3. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
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
                question12();
            }
            if (choice < 1 || choice > 3) {
                error = true;
            }

            if (choice == 3) {
                error = false;
                count = 16;
            } else if (choice == 1) {
                count = 18;
                temporaryinput = 1;
            } else if (choice == 2) {
                count = 19;
                temporaryinput = 0;
            }
        }
    }

    public void question13() {
        count = 18;
        clear();
        heading();
        if (choice == 1) {
            System.out.println(
                    "How much do you pay towards any outstanding debts this month (such as credit card payments, student loans, etc.)?\n-1. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            } else if (error) {
                System.out.println("\nPlease enter a positive value! Only -1 is accepted");
            }
            System.out.print("\nYour answer: ");
            try {
                inputmismatch = false;
                temporaryinput = in.nextDouble();
            } catch (InputMismatchException e) {
                in.nextLine();
                inputmismatch = true;
                temporaryinput = 0;
                question13(); // ilisdan
            }

            if (temporaryinput == -1) {
                count = 17; // ilisdan
                choice = 0;
                error = false;
            } else if (temporaryinput >= 0) {
                debtPayments += temporaryinput; // ilisdan
                error = false;
                temporaryinput = 0;
                count = 19;
            } else if (temporaryinput < -1) {
                error = true;
            }
        }
    }

    public void question14() {
        count = 19;
        clear();
        heading();
        System.out.println("How much do you set aside this month for savings? (This will not be deducted from your income)\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question14(); // ilisdan
        }

        if (temporaryinput == -1) {
            if(choice == 1){
                count = 18;
            }
            else if(choice == 0 || choice == 2 || choice == 3){
                count = 17;
            }
            error = false;
        } else if (temporaryinput >= 0) {
            savingsExpense += temporaryinput; // ilisdan
            error = false;
            temporaryinput = 0;
            count = 20;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question15() {
        //flagged. tax system dev to come up
        count = 20;
        clear();
        heading();
        System.out.println("What is your estimated monthly tax payment or deduction (If not applicable please enter 0)\n-1. Back");
        if (inputmismatch) {
            System.out.println("\nProgram does not accept non-numerical values!");
        }
        System.out.print("\nYour answer: ");
        try {
            inputmismatch = false;
            temporaryinput = in.nextDouble();
        } catch (InputMismatchException e) {
            in.nextLine();
            inputmismatch = true;
            temporaryinput = 0;
            question15(); // ilisdan
        }

        if (temporaryinput == -1) {
            count = 19; // ilisdan
            error = false;
        } else if (temporaryinput >= 0) {
            taxDeduct += temporaryinput; // ilisdan
            error = false;
            temporaryinput = 0;
            count = 21;
        } else if (temporaryinput < -1) {
            error = true;
        }
    }

    public void question16() {
        count = 21;
        choice = 0;
        error = false;
        while (choice < 1 || choice > 3) {
            clear();
            heading();
            System.out.println("Do you have a child? \n1. Yes\n2. No\n3. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            if (!error) {
                System.out.print("\nYour answer: ");
            } else {
                System.out.print("\nChoose the correct syntax: ");
            }
            try {
                inputmismatch = false;
                choice = in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
                inputmismatch = true;
                error = true;
                choice = 0;
            }
            if (choice < 1 || choice > 3) {
                error = true;
            }

            if (choice == 3) {
                error = false;
                count = 20;
            } else if (choice == 1) {
                count = 22;
                error = false;
            }
            else if(choice == 2){
                count = 23;
                error = false;
            }
        }
    }

    public void question17() {
        count = 22;
        clear();
        heading();
        if (choice == 1) {
            System.out.println("How much do you spend on child care and school tuition this month?\n-1. Back");
            if (inputmismatch) {
                System.out.println("\nProgram does not accept non-numerical values!");
            }
            System.out.print("\nYour answer: ");
            try {
                inputmismatch = false;
                temporaryinput = in.nextDouble();
            } catch (InputMismatchException e) {
                in.nextLine();
                inputmismatch = true;
                temporaryinput = 0;
                question17(); // ilisdan
            }

            if (temporaryinput == -1) {
                count = 21; // ilisdan
                choice = 0;
                error = false;
            } else if (temporaryinput >= 0) {
                childExpense += temporaryinput; // ilisdan
                error = false;
                temporaryinput = 0;
                count = 23;
            } else if (temporaryinput < -1) {
                error = true;
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
        return (getInc() - getTotalExpenses()) + getSavingsExpense();
    }
}
