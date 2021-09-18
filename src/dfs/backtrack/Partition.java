package dfs.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/5 20:22
 */
public class Partition {
    public List<List<String>>partition(String s){
        List<List<String>>result = new ArrayList<>();
        backtracking(result,new ArrayList<>(),s);
        return result;
    }
    private void backtracking(List<List<String>>list,List<String>temp,String s){
        if (s.length() == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0;i < s.length();i++){
            if (isPalindrome(s,0,i)){
                temp.add(s.substring(0,i+1));
                backtracking(list,temp,s.substring(i+1));
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int left,int right){
        while (left < right){
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
