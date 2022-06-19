package list;

import ref.ListNode;

/**
 * @author kanglo
 * @create 2022-03-2022/3/1 21:06
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
