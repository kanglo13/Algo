package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-10-2021/10/31 16:39
 */
public class ReconstructQueue {
    public int[][]reconstructQueue(int[][]people){
        Arrays.sort(people,(o1, o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o2[0]-o1[0]);
        List<int[]>list = new ArrayList<>();
        for (int i = 0;i <people.length;i++){
            list.add(people[i][1],people[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
