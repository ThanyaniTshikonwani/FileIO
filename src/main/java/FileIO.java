import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.*;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileIO {

    public  static final Logger logger = (Logger) LogManager.getLogger(FileIO.class);

    static String name;
    static int age;
    static String surname;
    static Date dateOfVisit;
    static Date timeOfvisit ;
    static String comments;
    static String assistant;




    public static void save() throws IOException {

        Scanner inputs = new Scanner(System.in);
        Scanner inputs3 =new Scanner(System.in);
        String run;
        Date date = new Date();


        dateOfVisit = date;
        timeOfvisit =date;

        do {
            try {
                System.out.println("Enter name");
                name = inputs.nextLine();

                System.out.println("Enter surname");
                surname = inputs.nextLine();

                String file =("visitor_"+name+"_"+surname+".txt");

                System.out.println("Enter Age");
                age=inputs.nextInt();

                System.out.println("Enter Assistant");
                assistant= inputs3.nextLine();

                System.out.println("Enter Comments");
                comments = inputs3.nextLine();



                String profile = ("Full Name: "+name+" "+surname+"\nAge: "+age+"\nDate of visit: "+dateOfVisit+"\nTime of visit: "
                        +timeOfvisit+"\nComments: "+comments+"\nAssisted by "+assistant+"\n" );

                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(profile);
                fileWriter.close();


                logger.info(file +" File saved!");
            }catch (InputMismatchException e){
                logger.error("Please enter your name");
            }
            System.err.println("Type A to capture more visitors Or Type Q to Quit");
            run=inputs3.nextLine();
        }while (run.equalsIgnoreCase("A"));
    }


    public  static  void load() throws IOException {

        String run;
        Scanner input2 = new Scanner(System.in);

        do {
            System.out.println("Please enter visitor Full-name");
            try {
                System.out.println("Enter name");
                name = input2.nextLine();
                System.out.println("Enter surname");
                surname = input2.nextLine();

                FileInputStream fileInputStream = new FileInputStream("visitor_"+name+"_"+surname+".txt");
                int text;
                while ((text = fileInputStream.read()) != -1) {
                    System.out.print((char) text);
                }
            } catch (Exception e) {
                logger.error("File does not exist");
            }
            logger.info(name+" "+surname+" profile viewed");
            System.err.println("Type V to view visitors Or Type Q to Quit");
            run = input2.nextLine();
        } while (run.equalsIgnoreCase("V"));
    }

}

