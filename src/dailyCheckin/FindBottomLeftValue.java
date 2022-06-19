package dailyCheckin;

import ref.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author kanglo
 * @create 2022-06-2022/6/22 20:44
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root){
        int res = -1;
        Deque<TreeNode>stack = new ArrayDeque<>();
        List<List<Integer>>list = new ArrayList<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            List<Integer>temp = new ArrayList<>();
            while (size-- > 0){
                TreeNode node = stack.pop();
                temp.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
            if (temp.size() > 0)
                list.add(temp);
        }
        if (list.size() > 0)
            res = list.get(list.size()-1).get(0);
        return res;
    }
}
