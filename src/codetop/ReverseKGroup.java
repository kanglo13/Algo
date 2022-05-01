package codetop;

import ref.ListNode;

import java.util.List;

/**
 * @author kanglo
 * @create 2022-02-2022/2/28 22:39
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode dummy = new ListNode(-1);
        dummy.next =head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next;
        int n = 0;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0;i <n / k;i++){
            for (int j = 0;j < k-1;j++){
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
        }
        return dummy.next;
    }
}
