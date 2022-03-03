
/**
 * 
 * Main logic calculation class for this project
 * 
 * @author Wei-Fan Lu
 * 
 * @version 2022-02-06
 */
public class CalculationLogic {
    /**
     *
     * the entrance of the function calculate the digit and operation
     * 
     * @param tokens
     *            the row of input string as a Calculation
     * 
     * @return string as equation answer
     */
    public static String bigNumArithmetric(String[] tokens) {

        Stack stack = new Stack(100);

        for (String s : tokens) {
            if (s.equals("+") || s.equals("*") || s.equals("^")) {
                if (stack.isEmpty()) {
                    return "";
                }
                ListNode second = stack.pop();
                if (stack.isEmpty()) {
                    return "";
                }
                ListNode first = stack.pop();

                if (s.equals("+")) {

                    stack.push(addition(first, second));

                }
                if (s.equals("*")) {

                    stack.push(multiplication(first, second));
                }
                if (s.equals("^")) {
                    stack.push(exponentiation(first, second));
                }

            }
            else if (stringIsNum(s)) {
                ListNode digit = stringToListNode(s);
                if (digit == null) {
                    return "";
                }
                stack.push(digit);
            }
            else {
                return "";
            }
        }
        ListNode res = stack.pop();
        if (!stack.isEmpty()) {
            return "";
        }

        String result = res.toString();

        return result;

    }


    /**
     * Judge the String is all digit or contain invalid character
     * 
     * @param s
     *            the String wished to be judged
     * 
     * @return true if the string is all digit
     *         false if string is invalid
     */
    public static Boolean stringIsNum(String s) {

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convert String to listNdoe
     * 
     * @param s
     *            the String want to convert to ListNode
     * 
     * @return ListNode of the string
     *         
     */
    public static ListNode stringToListNode(String s) {
        if (s.equals("")) {
            return null;
        }
        int n = s.length();
        ListNode head = new ListNode(s.charAt(n - 1) - '0');
        ListNode cur = head;

        for (int i = n - 2; i >= 0; i--) {
            ListNode next = new ListNode(s.charAt(i) - '0');
            cur.setNext(next);
            cur = next;

        }
        return head;
    }


    /**
     * Operation of "+" get the sum of two number
     * 
     * @param a
     *            the first Number present as listNode
     * @param b
     *            the second Number present as listNode
     * 
     * @return the addition result of A and B present as listNode
     * 
     */
    public static ListNode addition(ListNode a, ListNode b) {
        if (a == null || b == null) {

            return null;
        }

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (a != null || b != null) {

            int first = a == null ? 0 : a.getVal();
            int second = b == null ? 0 : b.getVal();

            int sum = (first + second + carry);
            carry = sum >= 10 ? 1 : 0;
            ListNode next = new ListNode(sum % 10);
            cur.setNext(next);
            cur = next;
            if (a != null) {
                a = a.getNext();
            }
            if (b != null) {
                b = b.getNext();
            }
        }
        if (carry > 0) {
            ListNode next = new ListNode(1);
            cur.setNext(next);
        }
        return dummy.getNext();
    }


    /**
     * Operation of "+" get the multiplication of two number
     * 
     * @param a
     *            the first Number present as listNode
     * @param b
     *            the second Number present as listNode
     * 
     * @return the multiplication result of A and B present as listNode
     * 
     */
    public static ListNode multiplication(ListNode a, ListNode b) {

        if (a == null || b == null) {
            return null;
        }
        String num1 = a.toString();
        String num2 = b.toString();
        int n1 = num1.length();
        int n2 = num2.length();
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        char[] res = new char[n1 + n2];
        for (int i = 0; i < res.length; i++) {
            res[i] = '0';
        }

        for (int i = n2 - 1; i >= 0; i--) {
            for (int j = n1 - 1; j >= 0; j--) {
                int product = (char2[i] - '0') * (char1[j] - '0');
                int tmp = res[i + j + 1] - '0' + product;
                res[i + j + 1] = (char)(tmp % 10 + '0');
                res[i + j] = (char)((res[i + j] - '0' + tmp / 10) + '0');
            }
        }

        String result = "";
        boolean isSeen = false;

        for (int i = 0; i < res.length; i++) {
            if (res[i] == '0' && !isSeen) {
                continue;
            }
            isSeen = true;
            result += res[i];
        }
        if (result.equals("")) {
            return new ListNode();
        }
        else {
            return stringToListNode(result);
        }

    }


    /**
     * Operation of "+" get the multiplication of two number
     * 
     * @param num1
     *            the first Number present as String
     * @param num2
     *            the second Number present as String
     * 
     * @return the multiplication result of A and B present as String
     * 
     */
    public static String stringMultiplication(String num1, String num2) {

        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 0 || n2 == 0) {
            return "";
        }
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        char[] res = new char[n1 + n2];
        for (int i = 0; i < res.length; i++) {
            res[i] = '0';
        }

        for (int i = n2 - 1; i >= 0; i--) {
            for (int j = n1 - 1; j >= 0; j--) {
                int product = (char2[i] - '0') * (char1[j] - '0');
                int tmp = res[i + j + 1] - '0' + product;
                res[i + j + 1] = (char)(tmp % 10 + '0');
                res[i + j] = (char)((res[i + j] - '0' + tmp / 10) + '0');
            }
        }

        String result = "";
        boolean isSeen = false;

        for (int i = 0; i < res.length; i++) {
            if (res[i] == '0' && !isSeen) {
                continue;
            }
            isSeen = true;
            result += res[i];
        }

        return result;
    }


    /**
     * Operation of "+" get the Exponentiation of two number
     * 
     * @param a
     *            the first Number present as listNode
     * @param b
     *            the second Number present as listNode
     * 
     * @return the Exponentiation result of A and B present as listNode
     * 
     */
    static ListNode exponentiation(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return null;
        }
        String exp = b.toString();
        String cur = a.toString();
        if (exp.equals("0") || cur.equals("1")) {
            return stringToListNode("1");
        }
        else if (cur.equals("0") || exp.equals("1")) {
            return stringToListNode(cur);
        }

        long n = Long.parseLong(exp);
        String res = "1";

        while (n > 0) {
            if (n % 2 == 1) {
                res = stringMultiplication(res, cur);
            }
            cur = stringMultiplication(cur, cur);
            n = n / 2;
        }

        return stringToListNode(res);

    }

}
