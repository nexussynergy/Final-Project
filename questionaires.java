import java.util.*;

public class questionaires {
    Scanner in = new Scanner(System.in);
    public int choice = 0;
    // 0 - unidentified
    // 1 - true
    // 2 - false
    int answer; // money value

    public void startingPrompt(){
        System.out.println("Good Day. This program will help you track your monthly expenses based on your income/salary.");
        System.out.print("If you want to continue please enter number one (1) else if you don't want to continue please enter number two (2)");
        System.out.print("\nChoice: ");
        choice = in.nextInt();
    }
    public void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
