/**
 * 
 * This is a linked list node data structure to store number to ListNode
 * 
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class ListNode {
    /**
     * Point to next ListNode
     */
    private ListNode next;
    /**
     * value of ListNode
     */
    private int val;
    /**
     * Initialize the ListNode value with val
     * 
     * @param val
     *            set up the val with val
     * 
     */
    public ListNode(int val) {
        this.val = val;
    }
    /**
     * Initialize the ListNode default value as zero
     */
    public ListNode() {
        this.val = 0;
    }
    /**
     *  ListNode convert to string by the end from head
     * 
     * 
     * @return  String of ListNoe (1->2->3  -> "321")
     *        
     */
    @Override
    public String toString() {
        String s = String.valueOf(this.val);
        ListNode node = this.next;
        while (node != null) {
            s = node.val + s;
            node = node.next;
        }
        return s;
    }

    /**
     * get the next ListNode
     * 
     * 
     * @return  get the next ListNode
     *        
     */
    public ListNode getNext() {
        return next;
    }

    
    /**
     *  set the next ListNode
     * 
     * @param next
     *            the ListNode wished to be set
     *        
     */
    public void setNext(ListNode next) {
        this.next = next;
    }


    /**
     * get the ListNode value
     * 
     * 
     * @return  get the next ListNode
     *        
     */
    public int getVal() {
        return val;
    }

    /**
     * set the ListNode value
     * 
     * @param val
     *            the val wished to be set
     *        
     */
    public void setVal(int val) {

        this.val = val;
    }

}
