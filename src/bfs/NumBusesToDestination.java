package bfs;

import java.util.*;

/**
 * @author kanglo
 * @create 2022-02-2022/2/10 21:09
 */
public class NumBusesToDestination {
    public int numBusesToDestination(int[][]routes,int source,int target){
        //某个车站可以进入的路线
        Map<Integer, Set<Integer>>map = new HashMap<>();
// 经过的路线
        Deque<Integer>deque = new ArrayDeque<>();
        Map<Integer,Integer>dis = new HashMap<>();
        int n = routes.length;
        for (int i = 0;i < n;i++){
            for (int station : routes[i]){
                if (station == source){
                    deque.add(i);
                    dis.put(i,1);
                }
                Set<Integer>set = map.getOrDefault(station,new HashSet<>());
                set.add(i);
                map.put(station,set);

            }
        }
        while (!deque.isEmpty()){
            int poll = deque.poll();
            int step = dis.get(poll);
            for (int station : routes[poll]){
                if (station == target)
                    return step;
                Set<Integer>lines = map.get(station);
                if (lines == null)
                    continue;
                for (int nr : lines){
                    if (!dis.containsKey(nr)){
                        dis.put(nr,step+1);
                        deque.add(nr);
                    }
                }

            }
        }
        return -1;
    }
    public int numBusesToDestinationII(int[][]routes,int source,int target){
        if (source == target)
            return 0;
        return 0;

    }
}
