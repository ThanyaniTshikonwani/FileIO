        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.core.Logger;

        import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.InputMismatchException;
        import java.util.Scanner;

        public class FileIO {

            public  static final Logger logger = (Logger) LogManager.getLogger(FileIO.class);

            static String name;
            static int age;
            static String surname;
            static String dateOfVisit;
            static String timeOfvisit ;
            static String comments;
            static String assistant;




            public static void save() throws IOException {

                Scanner inputs = new Scanner(System.in);
                Scanner inputs3 =new Scanner(System.in);
                String run;


                SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm:ss a");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd mm yyyy");

                dateOfVisit = simpleDateFormat.toString();
                timeOfvisit =simpleTimeFormat.toString();


                do {

                    System.out.println("Enter name");
                    name = inputs.nextLine();

                    System.out.println("Enter surname");
                    surname = inputs.nextLine();

                    try {
                        System.out.println("Enter Age");
                        age=inputs.nextInt();
                    }catch (InputMismatchException a){

                            System.out.println("Please input Age : e.g 13");
                    }

                    inputs.nextLine();
                    System.out.println("Enter Assistant");
                    assistant= inputs.nextLine();

                    System.out.println("Enter Comments");
                    comments = inputs.nextLine();



                        try {
                            if (true){
                                File file1 = new File("visitor_"+name+"_"+surname+".txt");
                                boolean exists = file1.exists();
                                System.out.println("visitor_"+name+"_"+surname+".txt"+"File already exits");
                                logger.info(exists+"File already exits");
                            }else {
                            String profile = ("Full Name: "+name+" "+surname+"\nAge: "+age+"\nDate of visit: "+dateOfVisit+"\nTime of visit: "
                                    +timeOfvisit+"\nComments: "+comments+"\nAssisted by "+assistant+"\n" );
                                String file =("visitor_"+name+"_"+surname+".txt");
                                FileWriter fileWriter = new FileWriter(file);
                                fileWriter.write(profile);
                                fileWriter.close();

                                logger.info(file +" File saved!");
                            }

                        }catch (InputMismatchException e){
                            logger.error("Please enter your name");
                        }

                    System.err.println("Type A to capture more visitors Or Type Q to Quit");
                    run=inputs3.nextLine();
                }while (run.equalsIgnoreCase("A"));
            }


            public  static String load() throws IOException {

                String run;
                Scanner input2 = new Scanner(System.in);

                do {
                    System.out.println("Please enter visitor Full-name");
                    try {
                        System.out.println("Enter name");
                        name = input2.nextLine();
                        System.out.println("Enter surname");
                        surname = input2.nextLine();

                        read();

                        }catch (Exception e){
                        logger.error("File does not exist");
                    }
                    logger.info(name+" "+surname+" profile viewed");
                    System.err.println("Type V to view visitors Or Type Q to Quit");
                    run = input2.nextLine();
                } while (run.equalsIgnoreCase("V"));
                return run;
            }

            public static String read() throws IOException {
                FileInputStream fileInputStream = new FileInputStream("visitor_" + name + "_" + surname + ".txt");
                int text;
                while ((text = fileInputStream.read()) != -1) {
                    System.out.print((char) text);
                }

                return "visitor_" +name + "_" + surname + ".txt";
            }

            public static String read(String s) throws IOException {
                String file =("visitor_Roni_Thanyani.txt");
             return file;
            }

            public static String save(String file) {
                return file;
            }
 }

