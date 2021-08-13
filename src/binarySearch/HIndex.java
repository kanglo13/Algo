package binarySearch;

/**
 * @author kanglo
 * @create 2021-08-2021/8/11 21:55
 * 0 1 3 5 6
 * 1 2 100
 * 1 2 4 5 100
 */
public class HIndex {
    public int hIndex(int[]citations){
        int n = citations.length;
        if (citations[n-1] == 0)
            return 0;
        int left = 0 ,right = n -1;
        while (left < right){
            int mid = left + (right - left);
            if (citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid;
        }
        return n - left;
    }
}
