import java.util.*;

public class decisions extends questionaires {
    Scanner in = new Scanner(System.in);

    public void invalidArgument() {
        heading();
        error = true;
    }

    public void proceed() {
        heading();
        welcomeMessage();
        while (choice != 1 && choice != 2) {
            clear();
            invalidArgument();
            welcomeMessage();
        }
        error = false;
        if (choice == 1) {
            clear();
            heading();
            currencyPreference();
            currencyConfirmation();
            incomeLoop();
        } else {
            clear();
            heading();
            System.out.println("Thank you for using our system.");
            System.exit(0);
        }
    }

    public void currencyConfirmation() {
        while (choice < 1 || choice > 5) {
            clear();
            invalidArgument();
            currencyPreference();
        }
        error = false;
        currencyplaceholder = choice - 1;
    }

    public void incomeLoop() {
        incomecon = false;
        while (!incomecon) {
            clear();
            heading();
            income();
            incomeConfirmation();
            while (choice < 1 || choice > 2) {
                clear();
                invalidArgument();
                incomeConfirmation();
            }
            error = false;
            incomecon = true;
        }
        if(choice == 1){
            surveyDecisions();
        }
        else{
            incomeLoop();
        }
    }

    public void surveyDecisions() {
        error = false;
        choice = 0;
        clear();
        heading();
        while(choice < 1 || choice > 2){
            clear();
            invalidArgument();
            surveyTermsAndConditions();
        }
        error = false;
        if(choice == 1){
            expenseSurvey();
        }
        else if(choice == 2){
            clear();
            heading();
            System.out.println("Thank you for using our system.");
            System.exit(0);
        }
    }
}