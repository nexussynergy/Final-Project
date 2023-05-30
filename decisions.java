import java.util.*;

public class decisions extends questionaires {
    Scanner in = new Scanner(System.in);

    public void invalidArgument() {
        heading();
        error = true;
    }

    public void proceed() {
        while (count <= 22) {
            if (count == 0) {
                welcomeMessage();
                if (choice != 1 && choice != 2) {
                    clear();
                    invalidArgument();
                    count = 0;
                } else if (choice == 2) {
                    clear();
                    heading();
                    System.out.println("Thank you for using our system.");
                    System.exit(0);
                } else {
                    error = false;
                }
            } else if (count == 1) {
                currencyPreference();
                currencyConfirmation();
            } else if (count == 2) {
                income();
            } else if (count == 3) {
                incomeConfirmation();
                if (choice < 1 || choice > 3) {
                    clear();
                    invalidArgument();
                    count = 3;
                } else {
                    error = false;
                    incomecon = true;
                }

                if (choice == 3) {
                    count = 1;
                } else if (choice == 2) {
                    count = 2;
                    incomecon = true;
                }
            } else if (count == 4) {
                surveyTermsAndConditions();
                if (choice < 1 || choice > 3) {
                    clear();
                    invalidArgument();
                    count = 4;
                } else {
                    error = false;
                }

                if (choice == 1) {
                    count = 5;
                } else if (choice == 2) {
                    System.out.println("Thank you for using our system.");
                    System.exit(0);
                }
                else if(choice == 3){
                    count = 3;
                    clear();
                    heading();
                }
            } else if (count == 5) {
                question0();
            }
            else if(count == 6){
                question1();
            }
            else if(count == 7){
                question2();
            }
            else if(count == 8){
                question3();
            }
            else if(count == 9){
                question4();
            }
            else if(count == 10){
                question5();
            }
            else if(count == 11){
                question6();
            }
            else if(count == 12){
                question7();
            }
            else if(count == 13){
                question8();
            }
            else if(count == 14){
                question9();
            }
            else if(count == 15){
                question10();
            }
            else if(count == 16){
                question11();
            }
            else if(count == 17){
                question12();
            }
            else if(count == 18){
                question13();
            }
            else if(count == 19){
                question14();
            }
            else if(count == 20){
                question15();
            }
            else if(count == 21){
                question16();
            }
            else if(count == 22){
                question17();
            }
        }
    }

    public void currencyConfirmation() {
        if (choice < 1 || choice > 6) {
            clear();
            invalidArgument();
            count = 1;
        } else {
            currencyplaceholder = choice - 1;
            error = false;
        }

        if (choice == 6) {
            count = 0;
        }

    }
}