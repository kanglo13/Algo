package SlidingWindow.interview;

import java.util.PriorityQueue;

/**
 * @author kanglo
 * @create 2022-07-2022/7/18 22:20
 */
public class MedianFinder {

    PriorityQueue<Integer>left;
    PriorityQueue<Integer>right;
    public MedianFinder(){
        left = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        right = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
    }
    public void addNum(int num){
        int leftCnt = left.size(), rightCnt = right.size();
        if (leftCnt == rightCnt){
            if (right.isEmpty() || num <= right.peek()){
                left.add(num);
            }else {
                left.add(right.poll());
                right.add(num);
            }
        }else {
            if (left.peek() <= num){
                right.add(num);
            }else {
                right.add(left.poll());
                left.add(num);
            }
        }

    }
    public double finMedian(){
        double res = 0;
        int leftCnt = left.size(), rightCnt = right.size();
        if (leftCnt == rightCnt){
            res  =  (double)(left.peek() / 2 + right.peek() / 2 );
        }
        else {
            res = (double) left.peek();
        }
        return res;
    }
}
