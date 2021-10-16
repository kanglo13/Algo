package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kanglo
 * @create 2021-09-2021/9/21 22:58
 */
public class FindOrder {
    public int[]findOrder(int numCourses,int[][]prerequisites){
        int index = 0;
        int[]result = new int[numCourses];
        if (prerequisites.length == 0){
            for (int i = 0;i < numCourses;i++){
                result[i] = i;
            }
            return result;
        }
        int[]inDegree = new int[numCourses];
        List<Integer>[] adj = new List[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i < numCourses;i++)
            adj[i] = new ArrayList<>();
        for (int[]pre : prerequisites){
            inDegree[pre[0]]++;
            adj[pre[1]].add(pre[0]);
        }
        for (int i = 0;i < numCourses;i++){
            if (inDegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            result[index++] = cur;
            for (int next : adj[cur]){
                if (--inDegree[next] == 0)
                    queue.add(next);
            }
        }
        if (index != numCourses-1)
            return new int[0];
        return result;
    }
}
