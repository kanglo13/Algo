package dailyCheckin;

import java.util.*;

/**
 * @author kanglo
 * @create 2021-12-2021/12/15 20:48
 */
public class LoudAndRich {
    public int[]loudAndRich(int[][]richer,int[]quiet){
        int n = quiet.length;
        Set<Integer>[] graph = new Set[n];
        for (int i = 0;i < n;i++){
            graph[i] = new HashSet<>();
        }
        for (int[]rich : richer){
            graph[rich[1]].add(rich[0]);
        }
        for (int i = 0;i < n;i++){
            for (int index : graph[i])
                if (graph[index].size() > 0)
                    graph[i].addAll(graph[index]);
        }
        PriorityQueue<Integer>queue = new PriorityQueue<>((o1, o2) -> quiet[o1] - quiet[o2]);
        int[]result = new int[n];
        for (int i = 0;i < n;i++){
            queue.addAll(graph[i]);
            result[i] = queue.isEmpty() ? i : queue.peek();
            queue.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        LoudAndRich loudAndRich  = new LoudAndRich();
        int[][]richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[]quiet = new int[]{3,2,5,4,6,1,7,0};
        int[]result = loudAndRich.loudAndRich(richer,quiet);
        for (int val : result){
            System.out.print(val + " ");
        }
    }
}
