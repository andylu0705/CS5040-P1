
/**
 * 
 * This is a stack data structure to store number in the equation
 * 
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class Stack {

    private ListNode[] arr;
    private int top;
    private int capacity;

    /**
     * Constructor to initialize the stack default size 100
     */
    Stack() {
        arr = new ListNode[100];
        capacity = 100;
        top = -1;

    }


    /**
     * Constructor to initialize the stack set the size
     * 
     * @param size
     *            set stack size with size
     * 
     */
    Stack(int size) {
        arr = new ListNode[size];
        capacity = size;
        top = -1;
    }


    /**
     * Convert String value to String
     * 
     * 
     * @return String of the stack
     * 
     */
    public String toString() {
        String result = "";
        for (int i = top; i >= 0; i--) {
            result += arr[top].toString();
        }
        return result;
    }


    /**
     * Function to add an element `x` to the stack
     * 
     * @param x
     *            add an element `x` to the stack
     * 
     */
    public void push(ListNode x) {

        arr[++top] = x;
    }


    /**
     * Function to pop a top element from the stack
     * 
     * 
     * @return top of the listNode
     * 
     */
    public ListNode pop() {

        return arr[top--];
    }


    /**
     * Function to return the top element of the stack
     * 
     * 
     * @return top of the listNode
     * 
     */
    public ListNode peek() {
        if (!isEmpty()) {
            return arr[top];
        }

        return null;
    }


    /**
     * Function to return the size of the stack
     * 
     * 
     * @return size
     * 
     */
    public int size() {
        return top + 1;
    }


    /**
     * Function to check if the stack is empty or not
     * 
     * 
     * @return true if stack is empty
     * 
     */
    public boolean isEmpty() {
        return top == -1; // or return size() == 0;
    }


    /**
     * Function to check if the stack is full or not
     * 
     * 
     * @return true if stack is full
     * 
     */
    public boolean isFull() {
        return top == capacity - 1; // or return size() == capacity;
    }
}
