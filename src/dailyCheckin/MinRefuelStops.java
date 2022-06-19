package dailyCheckin;

import java.util.PriorityQueue;

/**
 * @author kanglo
 * @create 2022-07-2022/7/2 11:25
 */
public class MinRefuelStops {
    public int minRefuelStops(int target,int startFuel,int[][]stations){
        PriorityQueue<Integer>q = new PriorityQueue<>((o1, o2) -> o2-o1);
        int ans = 0, len = stations.length;
        if (len < 1)
            return startFuel < target ? -1 : 0;
        int fuel = startFuel;
        for (int i = 0;i < len;i++){
            while (fuel < stations[i][0]){
                int add = q.poll();
                fuel += add;
                ans++;
            }
            q.offer(stations[i][1]);
        }
        while (fuel < target){
            int add = q.poll();
            fuel += add;
            ans++;
        }
        return ans;

    }
}
