package dp;

/**
 * @author kanglo
 * @create 2021-08-2021/8/29 10:49
 */
public class IsSubsequence {
    public boolean isSubsequence(String s,String t){
        if (s == null || s.length() == 0)
            return true;
        if (s.length() > t.length())
            return false;
        int index = -1;
        for (char ch : s.toCharArray()){
            index = t.indexOf(ch,index+1);
            if (index == -1)
                return false;
        }
        return true;
    }
}
