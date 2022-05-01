package list;

import ref.ListNode;

/**
 * @author kanglo
 * @create 2022-03-2022/3/1 21:11
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head,int left,int right){
        ListNode dummmyHead = new ListNode(-1);
        dummmyHead.next = head;
        ListNode pre = dummmyHead,cur,next;
        for (int i = 1;i < left;i++){
            pre = pre.next;
        }
        cur = pre.next;
        for (int i = left;i < right;i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return dummmyHead.next;
    }
}
