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
    float income;
    float housingUtilities;

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
        income = in.nextFloat();
    }

    public void incomeConfirmation() {
        System.out.println(
                "Please confirm if your income per month is " + df.format(income) + " "
                        + currencyCode[currencyplaceholder] + ".");
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
        choice = 0; // ILISDI NIG PANGALAN
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
            if(choice < 1 || choice > 2){
                error = true;
            }
        }
        clear();
        heading();
        System.out.println("How much do you pay for rent every month?");
        System.out.print("\nYour answer: ");
        housingUtilities = in.nextFloat();
    }
}
