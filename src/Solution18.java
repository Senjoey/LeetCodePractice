/**
 * @author Tan Qiong
 * @date 2020/10/18
 */
public class Solution18 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除倒数第n个元素
        ListNode toDeleteNext = slow.next.next;
        slow.next = toDeleteNext;
        return head;
    }

    public static void main(String[] args) {
//        ListNode five = new ListNode(5);
//        ListNode four = new ListNode(4, five);
//        ListNode three = new ListNode(3, four);
//        ListNode two = new ListNode(2, three);
//        ListNode head = new ListNode(1, two);

        ListNode head = new ListNode(1);
        System.out.println(new Solution18().removeNthFromEnd(head, 1));
    }
}
