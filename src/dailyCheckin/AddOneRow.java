package dailyCheckin;

import ref.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author kanglo
 * @create 2022-08-2022/8/5 22:43
 */
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root,int val,int depth){
        if (depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return root;
        }
        int level = 1;
        Deque<TreeNode>deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                TreeNode cur = deque.pollFirst();
                if (level == depth-1){
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    left.left = cur.left;
                    right.right = cur.right;
                    cur.left =  left;
                    cur.right = right;
                }else {
                    if (cur.left != null)
                        deque.addLast(cur.left);
                    if (cur.right != null)
                        deque.addLast(cur.right);
                }
                level++;
            }
        }
        return root;
    }
}
