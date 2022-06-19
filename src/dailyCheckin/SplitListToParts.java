package dailyCheckin;

import ref.ListNode;

import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/22 22:22
 */
public class SplitListToParts {
    public ListNode[]splitListToParts(ListNode head,int k){
        ListNode[]result = new ListNode[k];
        ListNode cur = head,pre = null;
        int len = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        int per = len / k, rest = len % k;
        cur = head;
        for (int i = 0;i < k;i++){
            result[i] = cur;
            if (pre != null)
                pre.next = null;
            for (int j = 0;j < per;j++){
                pre = cur;
                cur = cur.next;
            }
            if (rest > 0){
                pre = cur;
                cur = cur.next;
                rest--;
            }
        }
        return result;
    }
}
