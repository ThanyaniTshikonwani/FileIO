import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner sinput=new Scanner(System.in);
        String option;
        String quit;


       while (true){
           quit=sinput.nextLine();
           try {
               System.out.println("Please Press 1 to Add Visitors or Press 2 to view existing visitors" +
                       " Q to exit");
               option=sinput.nextLine();
               if (option.equalsIgnoreCase("1")){
                   FileIO.save();
               }else if (option.equalsIgnoreCase("2")){
                   FileIO.load();
               }
           }catch (IOException e){
               System.err.println("Invalid Inputs");
           }
           if (quit.equalsIgnoreCase("Q")){
               return;
           }
       }
    }
}
