
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * This is an unit test for BigNumArithmetic Class
 * 
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class BigNumArithmeticTest extends student.TestCase {
    private BigNumArithmetic bac;
    private ByteArrayOutputStream output;
    private String answer;

    /**
     * Initialize the objects for testing
     */
    @Before
    public void setUp() throws Exception {
        bac = new BigNumArithmetic();
        output = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(output));
        File file = null;
        try {
            Scanner scanner = null;
            file = new File("./testData/SampleOutput.txt");
            scanner = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            answer = sb.toString();
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Invalid file");
            e.printStackTrace();
        }
    }


    /**
     * Load commends from the file and execute the commands. After finishing
     * the commands, the program will compare the output with "SampleInput.txt"
     */
    @Test
    public void testMain() {
        try {
            bac.main(new String[] { "./testData/SampleInput.txt" });
            assertEquals(answer, output.toString());
        }
        catch (Exception e) {

            e.printStackTrace();
        }

    }


    /**
     * Test exception if the directory is invalid.
     */
    @Test
    public void testException() {
        try {

            bac.main(new String[] { "./data.dat" });

        }

        catch (Exception e) {

            fail("Trigger Fail");
        }
    }

}
