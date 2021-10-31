package dfs.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-10-2021/10/30 19:51
 */
public class LetterCasePermutation {
    public List<String>letterCasePermutation(String s){
        char[]chars = s.toCharArray();
        List<String>result = new ArrayList<>();
        backtrack(result,new StringBuilder(),chars,0);
        return result;

    }
    private void backtrack(List<String>result,StringBuilder sb,char[]chars,int start){
        if (sb.length() == chars.length){
            result.add(sb.toString());
        }
        for (int i = start;i < chars.length;i++){
            char ch = chars[i];
            if (Character.isDigit(ch)){
                sb.append(ch);
                backtrack(result,sb,chars,i+1);
                sb.deleteCharAt(sb.length()-1);
            }
            else if (Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
                backtrack(result,sb,chars,i+1);
                sb.deleteCharAt(sb.length()-1);

                sb.append(Character.toUpperCase(ch));
                backtrack(result,sb,chars,i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

}
