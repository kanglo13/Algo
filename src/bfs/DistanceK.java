package bfs;

import com.sun.source.tree.Tree;
import ref.TreeNode;

import java.util.*;

/**
 * @author kanglo
 * @create 2022-01-2022/1/19 22:46
 */
public class DistanceK {
    Map<TreeNode,TreeNode>map;
    Set<TreeNode>set;
    List<Integer>ans;
    public List<Integer>distanceK(TreeNode root,TreeNode target,int k){
        map = new HashMap<>();
        set = new HashSet<>();
        ans = new ArrayList<>();
        dfs(root);
        search(target,0,k);
        return ans;

    }
    public void search(TreeNode root,int count,int k){
        if (root == null)
            return;
        if (set.contains(root)){
            return;
        }
        if (count == k){
            ans.add(root.val);
            return;
        }
        set.add(root);
        search(map.get(root),count+1,k);
        search(root.left,count+1,k);
        search(root.right,count+1,k);
    }
    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            map.put(root.left,root);
            dfs(root.left);
        }
        if (root.right != null){
            map.put(root.right,root);
            dfs(root.right);
        }
    }
}
