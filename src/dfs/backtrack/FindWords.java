package dfs.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-09-2021/9/16 20:44
 */
public class FindWords {
    private int m;
    private int n;
    private char[][]board;
    private final int[][]direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public List<String>findWords(char[][]board,String[]words){
        List<String>result = new ArrayList<>();
        if (words.length== 0)
            return result;
        for (String word : words){
            if (exist(board,word))
                result.add(word);
        }
        return result;
    }
    private boolean exist(char[][]board,String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(visited, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean backtracking(boolean[][]visited,String word,int r,int c,int index){
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || board[r][c] != word.charAt(index))
            return false;
        if (index == word.length()-1)
            return true;
        visited[r][c] = true;
        for (int[]d : direction){
            if (backtracking(visited,word,r+d[0],c+d[1],index+1))
                return true;
        }
        visited[r][c] = false;
        return false;
    }
}
