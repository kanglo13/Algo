package dfs;

/**
 * @author kanglo
 * @create 2021-08-2021/8/18 21:19
 */
public class FloodFill {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[][]floodFill(int[][]image,int sr,int sc,int newColor){
        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == newColor)
            return image;
        dfs(image,sr,sc,m,n,oldColor,newColor);
        return image;

    }
    private void dfs(int[][]image,int r,int c,int m,int n,int oldColor,int newColor){
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != oldColor)
            return;
        image[r][c] = newColor;
        for (int[]d : direction){
            dfs(image,r+d[0],c+d[1],m,n,oldColor,newColor);
        }
    }
}
