package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/13 22:26
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[]nums,int k){
        int n = nums.length;
        int[]res = new int[n-k+1];
        Deque<Integer>deque = new ArrayDeque<>();
        for (int i = 0; i < n;i++){
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() <= i -k){
                deque.pollFirst();
            }
            if (i - k + 1 >= 0){
                res[i- k +1] = nums[deque.peekFirst()];
            }

        }
        return res;

    }
}
