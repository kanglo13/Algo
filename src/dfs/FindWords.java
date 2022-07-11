package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kanglo
 * @create 2022-07-2022/7/9 21:29
 */
public class FindWords {
    private final int[][]direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private int m;
    private int n;
    private char[][]board;

    class Node {
        boolean end;
        Node[]children = new Node[26];
    }
    Node root = new Node();
    private void insert(String word){
        Node cur = root;
        for (int i = 0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new Node();
            cur = cur.children[index];
        }
        cur.end = true;
    }
    private boolean startWith(String prefix){
        Node cur = root;
        for (int  i =0;i < prefix.length();i++){
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return true;
    }
    private boolean search(String word){
        Node cur = root;
        for (int i = 0;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null)
                return false;
            cur = cur.children[index];
        }
        return cur.end;
    }
    public List<String>findWords(char[][]board,String[] words){
        m = board.length;
        n = board[0].length;
        this.board = board;
        for (String word : words)
            insert(word);
        Set<String>res = new HashSet<>();
        boolean[][]visited = new boolean[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0; j < n; j++) {
                backtrack(visited,i,j,"",res);
            }
        }
        return new ArrayList<>(res);
    }
    private void backtrack(boolean[][]visited, int r, int c, String str, Set<String>set){
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c])
            return;
        str += board[r][c];
        if (!startWith(str))
            return;
        if (search(str))
            set.add(str);
        visited[r][c] = true;
        for (int[]d : direction){
            backtrack(visited,r+d[0],c+d[1],str,set);
        }
        visited[r][c] =false;
    }
}
