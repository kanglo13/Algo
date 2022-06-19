package list;

import ref.ListNode;

/**
 * @author kanglo
 * @create 2022-03-2022/3/1 21:27
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
          int n = 0;
          ListNode dummyHead = new ListNode(-1);
          dummyHead.next = head;
          ListNode pre = dummyHead;
          ListNode cur = head;
          ListNode next;
          while (cur != null){
              n++;
              cur = cur.next;
          }
          cur = head;
        for (int i = 0;i < n / k;i++){
            for (int j = 1;j < k;j++){
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;

    }
}
