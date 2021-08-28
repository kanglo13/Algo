package ref;

/**
 * @author kanglo
 * @create 2021-08-2021/8/18 22:02
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){

    }
   public TreeNode(int val){
        this.val = val;
    }
   public TreeNode(int val, TreeNode left,TreeNode right){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
