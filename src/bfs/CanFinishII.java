package bfs;

import java.util.*;

/**
 * @author kanglo
 * @create 2022-07-2022/7/25 23:19
 */
public class CanFinishII {
    public boolean canFinish(int numCourses,int[][]prerequisites){
        if (numCourses <= 0)
            return false;
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        int[]degree = new int[numCourses];
        Deque<Integer>deque = new ArrayDeque<>();
        List<Integer>[]graph = new List[numCourses];
        int count = 0;
        for (int i = 0;i < numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for (int[]pre : prerequisites){
            degree[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }
        for (int i = 0;i < numCourses;i++){
            if (degree[i] == 0)
                deque.addLast(i);
        }
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                int cur = deque.pollFirst();
                count++;
                for (int next : graph[cur]){
                    if (--degree[next] == 0){
                        deque.addLast(next);
                    }
                }
            }
        }
        return numCourses == count;
    }
}
