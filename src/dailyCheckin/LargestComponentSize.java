package dailyCheckin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2022-07-2022/7/31 20:48
 */
public class LargestComponentSize {
    class UF{
        private int count;
        private int[]size;
        private int[]parent;
        public UF(int n){
            count = n;
            size = new int[n];
            parent = new int[n];
            for (int i = 0;i < n;i++){
                size[i] = 1;
                parent[i] = i;
            }
        }
        public int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (size[rootP] > size[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else {
                parent[rootP] = rootQ;
                size[rootQ] += rootQ;
            }
            count--;
        }
        public int getCount(){
            return this.count;
        }
    }
    public int largestComponentSize(int[]nums){
        if (nums == null || nums.length == 0)
            return 0;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums){
            maxValue = Math.max(maxValue,num);
        }
        UF uf = new UF(maxValue + 1);
        for (int num : nums){
            for (int j = 2;j * j < num;j++){
                if (num % j == 0){
                    uf.union(num,j);
                    uf.union(num,num/j);
                }
            }
        }
        Map<Integer,Integer>map = new HashMap<>();
        int result = 0;
        for (int num : nums){
            int value = uf.find(num);
            map.put(value,map.getOrDefault(value,0)+1);
            result = Math.max(result,map.get(value));
        }
        return result;
    }
}
