package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/25 23:39
 */
public class FindOrderII {
    public int[]findOrder(int numCourses,int[][]prerequisites){
        if (numCourses <= 0)
            return new int[0];
        int[]res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0){
            for (int i = 0;i < numCourses;i++){
                res[i] = i;
            }
            return res;
        }
        int index = 0;
        int[]degree = new int[numCourses];
        List<Integer>[]graph = new List[numCourses];
        Deque<Integer>deque = new ArrayDeque<>();
        for (int i = 0;i < numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            degree[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }
        for (int i =0;i < numCourses;i++){
            if (degree[i] == 0)
                deque.addLast(i);
        }
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                int cur = deque.pollFirst();
                res[index++] = cur;
                for (int next : graph[cur]){
                    if (--degree[next] == 0){
                        deque.addLast(next);
                    }
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}
