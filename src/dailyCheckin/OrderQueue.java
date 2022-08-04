package dailyCheckin;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2022-08-2022/8/3 20:55
 */
public class OrderQueue {
    public String orderlyQueue(String s, int _k) {
        char[] cs = s.toCharArray();
        int[]nums = new int[26];

        if (_k == 1) {
            int i = 0, j = 1, k = 0, n = cs.length;
            while (i < n && j < n && k < n) {
                char a = cs[(i + k) % n], b = cs[(j + k) % n];
                if (a == b) k++;
                else {
                    if (a > b) i += k + 1;
                    else j += k + 1;
                    if (i == j) i++;
                    k = 0;
                }
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        } else {
            Arrays.sort(cs);
            return String.valueOf(cs);
        }
    }
}
