import java.io.File;
import java.util.Scanner;

/**
 * The class containing the main method, the entry point of the application.
 * to the console as specified in the file.
 *
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class BigNumArithmetic {
    /**
     * The entry point of the application.
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     */
    // On my honor:
    // - I have not used source code obtained from another student,
    // or any other unauthorized source, either modified or
    // unmodified.
    //
    // - All source code and documentation used in my program is
    // either my original work, or was derived by me from the
    // source code published in the textbook for this course.
    //
    // - I have not discussed coding details about this project
    // with anyone other than my partner (in the case of a joint
    // submission), instructor, ACM/UPE tutors or the TAs assigned
    // to this course. I understand that I may discuss the concepts
    // of this program with other students, and that another student
    // may help me debug my program so long as neither of us writes
    // anything during the discussion or modifies any computer file
    // during the discussion. I have violated neither the spirit nor
    // letter of this restriction.
    public static void main(String[] args) {
        
        String filename = args[0];
        // Pass the function a full filepath
        beginParsing(filename);
        // call the parsing function
        
    }


    /**
     * Handle the input file to remove space and front zero of digit
     * It will take a command line file argument which include the
     * commands to be read outputs the correct results
     * 
     * @param filename
     *            input string file
     * 
     */
    public static void beginParsing(String filename) {

        String rowString = "";
        try {
            
            Scanner sc = new Scanner(new File(filename));

            while (sc.hasNextLine()) {

                rowString = "";
                String line = sc.nextLine().trim();
                String[] strs = line.split(" ");

                for (String s : strs) {
                    // blanket
                    if (s.equals("")) {
                        continue;
                    }
                    // + * ^
                    else if (s.equals("+") || s.equals("*") || s.equals("^")) {
                        
                        rowString = rowString + s + " ";

                    }
                    // digit
                    else {
                        
                        char[] chars = s.toCharArray();
                        if (chars[0] == '0') {
                            // 0
                            int index = 0;
                            while (index < s.length() - 1
                                && chars[index] == '0') {
                                index++;
                            }
                            rowString = rowString + s.substring(index) + " ";
                        }
                        else {
                            rowString = rowString + s + " ";
                        }

                    }
                }

                if (!rowString.isEmpty()) {
                    CalculationLogic bc = new CalculationLogic();
                    String[] original = rowString.split(" ");
                    String result = bc.bigNumArithmetric(original);
                    System.out.println(rowString + "= " + result);

                }
            }
            sc.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

}
