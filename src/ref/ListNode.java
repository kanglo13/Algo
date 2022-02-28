package ref;

/**
 * @author kanglo
 * @create 2021-08-2021/8/15 16:24
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
