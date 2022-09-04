package contest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author kanglo
 * @create 2022-08-2022/8/28 10:44
 */
public class RemoveStars {
    public String removeStars(String s){
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf("*");
        if (index ==-1)
            return sb.toString();
        else {
            sb.deleteCharAt(index);
            sb.deleteCharAt(index+1);
        }
        return removeStars(s);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveStars().removeStars("erase*****"));

    }


}
