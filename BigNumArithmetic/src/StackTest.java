
import java.io.ByteArrayOutputStream;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * This is an unit test for Stack Class
 * 
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class StackTest extends student.TestCase {
    private Stack stack1;
    private Stack stack2;
    private ByteArrayOutputStream outputStream;
    
    /**
     * Initialize the objects for testing
     */    
    @Before
    public void setUp() throws Exception {
        stack1 = new Stack();
        stack2 = new Stack(1);
        outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));
    }

    /**
     * Test for push function check number push into the stack
     */ 
    @Test
    public void tesPush() {
        ListNode n1 = new ListNode(12);
        stack1.push(n1);
        assertEquals("12" , stack1.toString());

    }
    /**
     * Test for pop function check number pop out the stack
     */ 
    @Test
    public void tesPop() {
        ListNode n1 = new ListNode(12);
        stack1.push(n1);
        stack1.pop();
        assertEquals("" , stack1.toString());
    }
    /**
     * Test for pop function check Empty or not
     */ 
    @Test
    public void testEmpty() {
        ListNode n2 = new ListNode();
        assertTrue(stack1.isEmpty());
        stack2.push(n2);
        assertFalse(stack2.isEmpty());
        assertTrue(stack2.isFull());
        assertFalse(stack1.isFull());
        
    }
    /**
     * Test for peek function
     */ 
    public void testPeek() {
        ListNode n2 = new ListNode();
        assertEquals(null, stack1.peek());
        stack1.push(n2);
        System.out.println(stack1.peek());
        assertEquals("0\n", outputStream.toString());
        assertEquals(stack1.size(), 1);
        
    }

}
