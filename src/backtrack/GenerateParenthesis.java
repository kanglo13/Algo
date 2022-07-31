package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kanglo
 * @create 2022-07-2022/7/27 21:04
 */
public class GenerateParenthesis {
    public List<String>generateParenthesis(int n){
        Set<String>set = new HashSet<>();
        backtrack(set,new StringBuilder(),n,n);
        return new ArrayList<>(set);
    }
    private void backtrack(Set<String>res, StringBuilder sb, int left, int right){
        if (left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }
        if (left > right)
            return;
        if (left > 0){
            sb.append("(");
            backtrack(res,sb,left-1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right > 0){
            sb.append(")");
            backtrack(res,sb,left,right-1);
            sb.deleteCharAt(sb.length()-1);
        }


    }

    public static void main(String[] args) {
        int n = 3;
        GenerateParenthesis generateParenthesis= new GenerateParenthesis();
        List<String> list= generateParenthesis.generateParenthesis(n);
        for (String s : list) {
            System.out.printf(s);
        }
    }
}
