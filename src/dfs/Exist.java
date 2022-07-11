package dfs;

/**
 * @author kanglo
 * @create 2022-07-2022/7/9 21:06
 */
public class Exist {
    private static final int[][]direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    private int m;
    private int n;
    private char[][]board;
    private String word;
    public boolean exist(char[][]board,String word){
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        boolean[][]marked = new boolean[m][n];
        for (int i = 0;i < m;i++){
            for (int j =0;j < n;j++){
                    if (dfs(marked,i,j,0))
                        return true;
            }
        }
        return false;
    }
    private boolean dfs(boolean[][]marked,int r,int c,int index){
        if (r < 0 || r >= m || c < 0 || c >= n || marked[r][c] || board[r][c] != word.charAt(index))
            return false;
        if (index == word.length()-1)
            return true;
        marked[r][c] = true;
        for (int[]d : direction){
            if (dfs(marked,r+d[0],c+d[1],index+1))
                return true;
        }
        marked[r][c] = false;
        return false;
    }
}
