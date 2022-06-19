package dailyCheckin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2022-07-2022/7/1 23:35
 */
public class DiffWaysToCompute {
    char[]chars;
    public List<Integer>diffWaysToCompute(String s){
        chars = s.toCharArray();
        return dfs(0,s.length()-1);
    }
    public List<Integer>dfs(int l,int r){
        List<Integer>ans = new ArrayList<>();
        for (int i = l;i <= r;i++){
            if (chars[i] >= '0' && chars[i] <= '9')
                continue;
            List<Integer>list = dfs(l,i-1);
            List<Integer>list1 = dfs(i+1,r);
            for (int a : list){
                for (int b : list1){
                    int cur = 0;
                    if (chars[i] == '+')
                        cur = a + b;
                    else if (chars[i] == '-')
                        cur = a - b;
                    else
                        cur = a * b;
                    ans.add(cur);
                }
            }
        }
        if (ans.isEmpty()){
            int cur = 0;
            for (int i = l;i <= r;i++){
                cur = cur * 10 + (chars[i] - '0');
                ans.add(cur);
            }
        }
        return ans;
    }
}
