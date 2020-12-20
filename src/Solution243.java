/**
 * @author Tan Qiong
 * @date 2020/10/23
 */
public class Solution243 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {return true;}
        // Find middle node
        ListNode mid = middleNode(head);
        ListNode right = reverse(mid.next);
        boolean result = true;
        while (result && right!=null) {
            if(head.val != right.val) {
                result =false;
            }
            head = head.next;
            right = right.next;
        }
        return result;
    }
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode zero = new ListNode(0, one);
        ListNode head = new ListNode(1, zero);
        System.out.println(new Solution243().isPalindrome(head));
    }
}
