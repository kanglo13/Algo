package dailyCheckin;

/**
 * @author kanglo
 * @create 2021-08-2021/8/14 11:12
 */
public class UnhappyFriends {
    public int unhappyFriends(int n,int[][]preferences,int[][]pairs){
        int[][]order = new int[n][n];
        int[]match = new int[n];
        int result = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n -1 ;j++){
                order[i][preferences[i][j]] = j;
            }
        }
        for (int[] person : pairs) {
            match[person[0]] = person[1];
            match[person[1]] = person[0];
        }
        for (int x = 0;x < n;x++){
            int y = match[x];
            int index = order[x][y];
            for (int i = 0;i < index;i++){
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]){
                    result++;
                    break;
                }
            }
        }
        return result;

    }
}
