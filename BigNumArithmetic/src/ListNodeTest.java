import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;

/**
 * 
 * This is an unit test for ListNode Class
 * 
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class ListNodeTest extends student.TestCase {
    private ListNode listNode;
    private ListNode listNode2;
    private ListNode firstDigit;
    private ByteArrayOutputStream outputStream;
    
    /**
     * Initialize the objects for testing
     */    
    @Before
    public void setUp() throws Exception {
        listNode = new ListNode();
        listNode2 = new ListNode(5);
        outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
        ListNode secondDigit = new ListNode(1);
        firstDigit = new ListNode(1);
        firstDigit.setNext(secondDigit);
    }

    /**
     * Test for set function
     */    
    @Test
    public void testSet() {
        listNode.setVal(2);
        assertEquals(2, listNode.getVal());
        
        listNode.setNext(listNode2);
        System.out.println(listNode2);
        assertEquals("5\n", outputStream.toString());
        
    }

    /**
     * Test for Next
     */    
    @Test
    public void testNext() {
        listNode.setNext(listNode2);
        listNode = listNode.getNext();
        assertEquals("5", listNode.toString());
    }
    /**
     * Test for 2 digits
     */    
    @Test
    public void testSecondDigit() {
        listNode.setNext(firstDigit);
        System.out.print(firstDigit);
        assertEquals("11", outputStream.toString());
    }

}
