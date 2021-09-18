package dailyCheckin;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-09-2021/9/3 23:02
 */
public class SmallestK {
    public int[]smallestK(int[]arr,int k){
        if (arr == null | arr.length == 0)
            return new int[0];
        int l = 0, h = arr.length-1;
        while (l < h){
            int povit = partition(arr,l,h);
            if (povit == k)
                return Arrays.copyOfRange(arr,0,k);
            else if (povit < k)
                l = povit + 1;
            else
                h = povit - 1;
        }
        return new int[0];

    }
    private int partition(int[]arr,int l,int h){
        int i = l, j = h + 1;
        int povit = arr[l];
        while (true){
            while (i != h && arr[++i] < povit);
            while (j != l && arr[--j] > povit);
            if (i >= j)
                break;
            swap(arr,i,j);
        }
        swap(arr,j,l);
        return j;
    }
    private void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
}
