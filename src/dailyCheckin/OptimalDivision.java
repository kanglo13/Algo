package dailyCheckin;

/**
 * @author kanglo
 * @create 2022-02-2022/2/27 10:25
 */
public class OptimalDivision {
    public String optimalDivision(int[]nums){
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < n;i++){
            sb.append(nums[i]);
            if (i+1 < n)
                sb.append("/");
        }
        if (n > 2){
            sb.insert(sb.indexOf("/")+1,"(");
            sb.append(")");
        }
        return sb.toString();
    }
}
