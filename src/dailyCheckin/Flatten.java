package dailyCheckin;

import ref.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/24 21:12
 */
public class Flatten {
    List<Node> list = new ArrayList<>();
    public Node flatten(Node head){
        dfs(head);
        Node dummyHead = new Node();
        Node pre = dummyHead;
        for (int i = 0;i < list.size();i++){
            Node cur = list.get(i);
            cur.prev = pre;
            pre.next = cur;
            pre = cur.next;
            if (i == list.size()-1)
                cur.next = null;
        }
        return dummyHead.next;

    }
    public  void dfs(Node head){
        if (head == null)
            return;
        list.add(head);
        dfs(head.child);
        dfs(head.next);
    }
}
