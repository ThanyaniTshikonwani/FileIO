import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sinput=new Scanner(System.in);
        String option;

               System.out.println("Please Press 1 to Add Visitors or Press 2 to view existing visitors" +
                       " Q to exit");
               option=sinput.nextLine();
               if (option.equalsIgnoreCase("1")){
                   FileIO.save();
               }else if (option.equalsIgnoreCase("2")){
                   FileIO.load();
               }
           }
 }

