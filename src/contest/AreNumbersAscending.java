package contest;

import java.util.List;

/**
 * @author kanglo
 * @create 2021-10-2021/10/17 10:50
 */
public class AreNumbersAscending {
    public  boolean areNumbersAscending(String s){
        String[]strs = s.split(" ");
        int pre = -1;
        for (String str : strs){
            if (Character.isDigit(str.charAt(0))){
                int cur = Integer.parseInt(str);
                if (cur <= pre)
                    return false;
                else {
                    pre = cur;
                }
            }
        }
        return true;
    }
}
