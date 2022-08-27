package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-08-2022/8/25 19:41
 */
public class FindClosestElements {
    public List<Integer>findClosestElements(int[]arr,int k,int x){
        List<Integer>res = new ArrayList<>();
        int n = arr.length;
        int left = 0, right = n - 1 -k;
        while (left < right){
            int mid = left + (right-left) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        for (int i = left;i < left+k;i++)
            res.add(arr[i]);
        return res;
    }
}
