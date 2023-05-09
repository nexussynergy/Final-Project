import java.util.*;

public class questionaires {
    Scanner in = new Scanner(System.in);
    public int choice = 0;
    // 0 - unidentified
    // 1 - true
    // 2 - false
    String currencyCode[] = { "USD", "EUR", "INR", "JPY", "PHP" };
    int currencyplaceholder;
    boolean error = false;
    boolean incomecon = true;
    int income;

    public void heading() {
        System.out.println("LOGISTICS - MONTHLY EXPENSE TRACKER");
        System.out.println("-----------------------------------\n");
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
        choice = in.nextInt();
        income = choice;
    }

    public void incomeConfirmation() {
        System.out.println(
                "Please confirm if your income per month is " + income + " " + currencyCode[currencyplaceholder] + ".");
        System.out.print("To continue please, enter:\n\n1. Confirm\n2. Rewrite");
        if (!error) {
            System.out.print("\nConfirm Input: ");
        } else {
            System.out.print("\nChoose the correct syntax: ");
        }
        choice = in.nextInt();
    }

    public void expenseSurvey() {
        System.out.println("The program will ask you questions about your spending habits to track your monthly expenses. This will help you see where your money is going and identify potential areas for savings. You'll be asked specific questions for each expense category, such as how much you spend and if you have recurring bills. Answer accurately for the most helpful insights.");
    }
}
