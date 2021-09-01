package dailyCheckin;

/**
 * @author kanglo
 * @create 2021-09-2021/9/1 20:36
 */
public class CompareVersion {
    public int compareVersion(String version1,String version2){
        String[]strs1 = version1.split("\\.");
        String[]strs2 = version2.split("\\.");
        int m =strs1.length,n = strs2.length;
        int i = 0,j = 0;
        while (i < m || j < n){
            int v1 = 0,v2= 0;
            if (i < m){
                v1 = Integer.parseInt(strs1[i++]);
            }
            if (j < n){
                v2 = Integer.parseInt(strs2[j++]);
            }
            if (v1 < v2)
                return -1;
            if (v1 > v2)
                return 1;
        }
        return 0;
    }
}
