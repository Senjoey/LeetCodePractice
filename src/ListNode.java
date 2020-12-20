/**
 * @author Tan Qiong
 * @date 2020/10/18
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    @Override
    public String toString() {
        if (next == null) {return "null";}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        while (next!=null) {
            stringBuilder.append(" ");
            stringBuilder.append(next.val);
            next = next.next;
        }
       return stringBuilder.toString();
    }

}
