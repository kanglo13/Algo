package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/11 22:26
 */
public class MySqrt {
    public int mySqrt(int x){
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int left = 1, right = x / 2;
        while (left < right){
            int mid = left + (right - left+1) / 2;
            if (mid > x / mid)
                right = mid -1;
            else
                left = mid;

        }
        return left;
    }
}
