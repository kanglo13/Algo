package twoPoint;

import ref.ListNode;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 16:45
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode fast = head;
        ListNode slow = head;
        while (n-- > 0)
            fast = fast.next;
        if (fast == null)
            return head.next;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
