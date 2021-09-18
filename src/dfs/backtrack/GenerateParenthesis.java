package dfs.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/5 20:03
 */
public class GenerateParenthesis {
    public List<String>generateParenthesis(int n){
        List<String>result = new ArrayList<>();
        backtrack(0,0,n,new StringBuilder(),result);
        return result;
    }
    private void backtrack(int left,int right,int n,StringBuilder temp,List<String>list){
        if (left == n && right == n){
            list.add(temp.toString());
            return;
        }
        if (left < right)
            return;
        if (left < n){
            temp.append("(");
            backtrack(left+1,right,n,temp,list);
            temp.deleteCharAt(temp.length()-1);
        }
        if (right < n){
            temp.append(")");
            backtrack(left,right+1,n,temp,list);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
