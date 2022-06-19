package dailyCheckin;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2022-06-2022/6/1 22:53
 */
public class MakeSquare {
    int target = 0;
    public boolean makeSquare(int[]matchSticks){
        if (matchSticks == null || matchSticks.length == 0)
            return false;
        int n = matchSticks.length,sum = 0,max = 0;
        for (int num : matchSticks){
            sum += num;
            if (max < num)
                max = num;
        }
        target = sum / 4;
        if (target * 4 != sum || max > target)
            return false;
        Arrays.sort(matchSticks);
        boolean[]flag = new boolean[n];
        return dfs(matchSticks,flag,0,target,0);
    }
    private boolean dfs(int[]nums,boolean[]flag,int cur,int sum,int cnt){
        if (cnt == 3)
            return true;
        if (sum == 0)
            return dfs(nums,flag,0,target,cnt+1);
        for (int i =0;i < nums.length;i++){
            if (flag[i])
                continue;
            if (nums[i] > sum)
                return false;
            flag[i] = true;
            if (dfs(nums,flag,i+1,sum-nums[i],cnt))
                return true;
            while (i+1 < nums.length && nums[i] == nums[i+1])
                i++;
        }
        return false;
    }
}
