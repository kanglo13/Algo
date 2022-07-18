package dailyCheckin;

/**
 * @author kanglo
 * @create 2022-07-2022/7/17 0:03
 */
public class ArrayNesting {
    public int arrayNesting(int[]nums){
        int n = nums.length;
        int res = 0;
        boolean[]visited = new boolean[n];
        for (int i = 0;i < n;i++){
            if (!visited[i])
                res = Math.max(res,dfs(nums,visited,i));
        }
        return res;
    }
    private int dfs(int[]nums,boolean[]visited,int index){
        if (index >= nums.length)
            return 0;
        if (visited[index])
            return 0;
        visited[index] = true;
        return 1 + dfs(nums,visited,nums[index]);
    }
}
