package dailyCheckin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kanglo
 * @create 2022-01-2022/1/9 11:33
 */
public class SlowestKey {
    public char slowestKey(int[]releaseTimes,String keysPressed){
        int[]time = new int[keysPressed.length()];
        for (int i = 0;i < keysPressed.length();i++){
            if (i == 0)
                time[i] = releaseTimes[i];
            else {
                time[i] = releaseTimes[i] -releaseTimes[i-1];
            }
        }

        PriorityQueue<Integer>queue = new PriorityQueue<>((o1, o2) -> time[o2] - time[o1]);
        for (int i = 0;i < keysPressed.length();i++)
            queue.add(i);
        return keysPressed.charAt(queue.peek());

    }
}
