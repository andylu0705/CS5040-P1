
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * This is an unit test for CalculationLogic Class
 * 
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class CalculationLogicTest extends student.TestCase {
    private CalculationLogic cl;
    private ListNode nullNode;
    private ListNode validNode;

    /**
     * Initialize the objects for testing
     */    
    @Before
    public void setUp() throws Exception {
        cl = new CalculationLogic();
        nullNode = null;
        validNode = new ListNode(1);
    }

    /**
     * Test Addition function
     */
    @Test
    public void testAddition() {
        String[] strs = { "1", "2", "+" };
        assertEquals("3", cl.bigNumArithmetric(strs));
        String[] strs2 = { "99", "1", "+" };
        assertEquals("100", cl.bigNumArithmetric(strs2));
        String[] strs3 = { "1", "99", "+" };
        assertEquals("100", cl.bigNumArithmetric(strs3));
        String[] strs4 = { "0", "1", "+" };
        assertEquals("1", cl.bigNumArithmetric(strs4));
        String[] strs5 = { "1", "0", "+" };
        assertEquals("1", cl.bigNumArithmetric(strs5));
        String[] strs6 = { "", "0", "+" };
        assertEquals("", cl.bigNumArithmetric(strs6));
        String[] strs7 = { "", "", "+" };
        assertEquals("", cl.bigNumArithmetric(strs7));
    }

    /**
     * Test Addition function with null node
     */
    @Test
    public void testAdditionNull() {
        assertEquals(null, cl.addition(nullNode, validNode));
        assertEquals(null, cl.addition(validNode, nullNode));
        assertEquals(null, cl.addition(nullNode, nullNode));
        assertEquals("2", cl.addition(validNode, validNode).toString());
    }

    /**
     * Test Multiplication function
     */
    @Test
    public void testMultiplication() {
        String[] strs = { "10", "25", "*" };
        assertEquals("250", cl.bigNumArithmetric(strs));
        String[] strs2 = { "0", "25", "*" };
        assertEquals("0", cl.bigNumArithmetric(strs2));
        String[] strs3 = { "25", "0", "*" };
        assertEquals("0", cl.bigNumArithmetric(strs3));
        String[] strs4 = { "0", "0", "*" };
        assertEquals("0", cl.bigNumArithmetric(strs4));
        String[] strs5 = { "0", "", "*" };
        assertEquals("", cl.bigNumArithmetric(strs5));
        String[] strs6 = { "", "0", "*" };
        assertEquals("", cl.bigNumArithmetric(strs6));
        String[] strs7 = { "", "", "*" };
        assertEquals("", cl.bigNumArithmetric(strs7));

    }

    /**
     * Test Multiplication function with null node
     */
    @Test
    public void testMultiplicationNull() {
        assertEquals(null, cl.multiplication(nullNode, validNode));
        assertEquals(null, cl.multiplication(validNode, nullNode));
        assertEquals(null, cl.multiplication(nullNode, nullNode));
        assertEquals("2", cl.addition(validNode, validNode).toString());
    }

    /**
     * Test Exponentiation function
     */
    @Test
    public void testExponentation() {
        String[] strs = { "10", "2", "^" };
        assertEquals("100", cl.bigNumArithmetric(strs));
        String[] strs1 = { "2345", "1", "^" };
        assertEquals("2345", cl.bigNumArithmetric(strs1));
        String[] strs2 = { "1", "100", "^" };
        assertEquals("1", cl.bigNumArithmetric(strs2));
        String[] strs3 = { "0", "100", "^" };
        assertEquals("0", cl.bigNumArithmetric(strs3));
        String[] strs4 = { "235", "0", "^" };
        assertEquals("1", cl.bigNumArithmetric(strs4));
        String[] strs5 = { "0", "0", "^" };
        assertEquals("1", cl.bigNumArithmetric(strs5));
        String[] strs6 = { "", "0", "^" };
        assertEquals("", cl.bigNumArithmetric(strs6));
        String[] strs7 = { "235", "", "^" };
        assertEquals("", cl.bigNumArithmetric(strs7));
        String[] strs8 = { "", "", "^" };
        assertEquals("", cl.bigNumArithmetric(strs8));
        assertEquals("", cl.stringMultiplication("1", ""));
        assertEquals("", cl.stringMultiplication("", "1"));
        assertEquals("", cl.stringMultiplication("1", ""));
        
    }
    /**
     * Test Exponentiation function with null node
     */
    public void testExponentationNull() {
        assertEquals(null, cl.exponentiation(nullNode, validNode));
        assertEquals(null, cl.exponentiation(validNode, nullNode));
        assertEquals(null, cl.exponentiation(nullNode, nullNode));
        assertEquals("1", cl.exponentiation(validNode, validNode).toString());
    }

    /**
     * Test Edge case
     */
    @Test
    public void testEdge() {
        String[] strs = { "10", "20" };
        assertEquals("", cl.bigNumArithmetric(strs));
        String[] strs2 = { "+" };
        assertEquals("", cl.bigNumArithmetric(strs2));
        String[] strs3 = { "3", "*" };
        assertEquals("", cl.bigNumArithmetric(strs3));
        String[] strs4 = { "3a", "*" };
        assertEquals("", cl.bigNumArithmetric(strs4));

    }

}
