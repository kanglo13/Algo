package backtrack;

import ref.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-07-2022/7/31 10:00
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root){
        Deque<TreeNode>deque = new ArrayDeque<>();
        Map<Integer,Integer>map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int level = 0;
        if (root == null)
            return 0;
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int sum = 0;
            level++;
            while (size-- > 0){
                TreeNode cur = deque.pollFirst();
                sum += cur.val;
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            map.putIfAbsent(sum,level);
            max = Math.max(max,sum);
        }
        return map.getOrDefault(max,0);
    }
}
