package twoPoint;

import ref.ListNode;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 16:26
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head){
        if (head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
