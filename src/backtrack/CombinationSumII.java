package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/27 21:42
 */
public class CombinationSumII {
    public List<List<Integer>>combinationSum(int[]candidates,int target){
        List<List<Integer>>res = new ArrayList<>();
        boolean[]visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(res,new ArrayList<>(),candidates,visited,target,0);
        return res;
    }
    private void backtrack(List<List<Integer>>res,List<Integer>list,int[]candidates,boolean[]visited,int target,int start){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0)
            return;
        for (int i =start;i < candidates.length;i++){
            if (candidates[i] > target)
                continue;
            if (visited[i])
                continue;
            if (i != 0 && candidates[i] == candidates[i-1] && !visited[i-1])
                continue;
            visited[i] = true;
            list.add(candidates[i]);
            backtrack(res,list,candidates,visited,target-candidates[i],i+1);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
