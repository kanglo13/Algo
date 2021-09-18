package dailyCheckin;

import java.util.*;

/**
 * @author kanglo
 * @create 2021-09-2021/9/8 21:08
 */
public class FindMaximizedCapital {
    public int findMaximizedCapital(int k,int w,int[]profits,int[]capital){
        int n = profits.length;
        List<int[]>list = new ArrayList<>();
        for (int i = 0;i < n;i++){
            list.add(new int[]{capital[i],profits[i]});
        }
        Collections.sort(list,(o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<Integer>queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int i = 0;
        while (k-- > 0){
            while (i < n && list.get(i)[0] <= w)
                queue.add(list.get(i++)[1]);
            if (queue.isEmpty())
                break;
            w += queue.poll();
        }
        return w;
    }
}
