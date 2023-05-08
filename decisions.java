import java.util.*;

public class decisions extends questionaires{
    Scanner in = new Scanner(System.in);
    public void proceed(){
        System.out.println(choice);
        while(choice != 1 || choice != 2){
            System.out.println(choice);
            System.out.print("Choose the correct syntax: ");
            choice = in.nextInt();
            clear();
        }
        if(choice == 1){

        }
        else{
            System.out.println("Thank you for using our system.");
        }
    }
}
