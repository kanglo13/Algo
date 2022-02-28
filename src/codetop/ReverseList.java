package codetop;

import ref.ListNode;

import java.util.List;

/**
 * @author kanglo
 * @create 2022-02-2022/2/27 16:21
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next =  pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode reverseBetween(ListNode head,int left,int right){
        ListNode dummyHead  = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 1;i < left;i++)
            pre = pre.next;
        ListNode cur = pre.next;
        for (int i = left;i < right;i++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }
}
