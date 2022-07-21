package SlidingWindow;

import java.util.PriorityQueue;

/**
 * @author kanglo
 * @create 2022-07-2022/7/18 21:58
 */
public class MedianSlidingWindow {
    public double[]medianSlidingWindow(int[]nums,int k){
        int n = nums.length;
        double[]res = new double[n-k+1];
        PriorityQueue<Integer>left = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        PriorityQueue<Integer>right = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        for (int i = 0; i < k;i++){
            right.add(nums[i]);
        }
        for (int i = 0;i <  k / 2;i++){
            left.add(right.poll());
        }
        res[0] = getMedian(left,right);
        for (int i = k;i < n;i++){
            int add = nums[i], del = nums[i-k];
            if (add >= right.peek()){
                right.add(add);
            }else {
                left.add(add);
            }
            if (del >= right.peek()){
                right.remove(del);
            }
            else {
                left.remove(del);
            }
            solve(left,right);
            res[i-k+1] = getMedian(left,right);
        }
        return res;
    }
    private void solve(PriorityQueue<Integer>left,PriorityQueue<Integer>right){
        while (left.size() > right.size())
            right.add(left.poll());
        while (right.size() - left.size() - 1 > 0)
            left.add(right.poll());
    }
    private double getMedian(PriorityQueue<Integer>left,PriorityQueue<Integer>right){
        if (left.size() == right.size()){
            return (double) (left.peek() / 2 + right.peek() / 2);
        }
        else {
            return (double) right.peek();
        }
    }
}
