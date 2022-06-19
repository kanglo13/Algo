package bfs;



import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-02-2022/2/8 22:33
 */
public class MinimumOperations {
    public int minimumOperations(int[]nums,int start,int goal){
        Deque<Integer>deque = new ArrayDeque<>();
        Map<Integer,Integer>map = new HashMap<>();
        deque.add(start);
        while (!deque.isEmpty()){
            int cur = deque.poll();
            int step = map.get(cur);
            for (int num : nums){
                int[]result = new int[]{cur+num,cur - num,cur ^ num};
                for (int next : result){
                    if (next == goal)
                        return step+1;
                    if (next < 0 || next > 1000)
                        continue;
                    if (map.containsKey(next))
                        continue;
                    map.put(next,step+1);
                    deque.add(next);
                }
            }
        }
        return -1;
    }
    private int[]nums;
    public int minimumOperationsII(int[]nums,int start,int goal){
        this.nums = nums;
        Deque<Long>deque1 = new ArrayDeque<>(),deque2 = new ArrayDeque<>();
        Map<Long,Integer>map1 = new HashMap<>(),map2 = new HashMap<>();
        deque1.add((long) start);
        deque2.add((long) goal);
        map1.put((long) start,0);
        map2.put((long) goal,0);
        while (!deque1.isEmpty() && !deque2.isEmpty()){
            if (deque1.size() < deque2.size()){
                int ans = update(deque1,map1,deque2,map2,true);
                if (ans != -1)
                    return ans;
            }
            else {
                int ans = update(deque1,map1,deque2,map2,false);
                if (ans != -1)
                    return ans;
            }
        }
        return -1;
    }
    private int update(Deque<Long>deque1,Map<Long,Integer>map1,Deque<Long>deque2,Map<Long,Integer>map2,boolean flag){
        long cur = deque1.poll();
        int step = map1.get(cur);
        for (int num : nums){
            if (flag){
                if (0 <= cur && cur <= 1000){
                    long[]result = new long[]{cur+num,cur-num,cur^num};
                    for (long  next : result){
                        if (map2.containsKey(next))
                            return step+1+map2.get(next);
                        if (!map1.containsKey(next)){
                            deque1.add(next);
                            map1.put(next,step+1);
                        }
                    }
                }
            }
            else {
                long[]result = new long[]{cur+num,cur-num,cur^num};
                for (long next : result){
                    if (next >= 0 && next <= 1000){
                        if (map2.containsKey(next))
                            return step + 1 + map2.get(next);
                        if (!map1.containsKey(next)){
                            map1.put(next,step+1);
                            deque1.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
