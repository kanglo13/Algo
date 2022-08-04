package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author kanglo
 * @create 2022-07-2022/7/27 21:23
 */
public class CombinationSum {
    public List<List<Integer>>combinationSum(int[]candidates,int target){
        List<List<Integer>>res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    private void backtrack(List<List<Integer>>res,List<Integer> list,int[]candidates,int target,int start){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0)
            return;
        for (int i = start;i < candidates.length;i++){
            if (candidates[i] <= target){
                list.add(candidates[i]);
                backtrack(res,list,candidates,target-candidates[i],i);
                list.remove(list.size()-1);
            }
        }
    }
}
