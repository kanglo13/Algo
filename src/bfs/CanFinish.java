package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kanglo
 * @create 2021-09-2021/9/21 22:46
 */
public class CanFinish {
    public boolean canFinish(int numCourses,int[][]prerequisites){
        if (numCourses <= 0)
            return false;
        if (prerequisites.length == 0)
            return true;
        int count = 0;
        int[]inDegree = new int[numCourses];
        List<Integer>[]adj = new List[numCourses];
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 0;i < numCourses;i++){
            adj[i] = new ArrayList<>();
        }
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
            count++;
            for (int next : adj[cur]){
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.add(next);
            }
        }
        return count == numCourses;
    }
}
