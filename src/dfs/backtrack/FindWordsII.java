package dfs.backtrack;

import java.util.*;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 9:57
 */
public class FindWordsII {
    class TrieNode{
        public TrieNode[]next = new TrieNode[26];
        public String word = "";
        public TrieNode(){

        }
    }
    class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode cur = root;
            for (char ch : word.toCharArray()){
                if (cur.next[ch-'a'] == null){
                    cur.next[ch-'a'] = new TrieNode();
                }
                cur = cur.next[ch-'a'];
            }
            cur.word = word;
        }
        public boolean search(String word){
            TrieNode cur = root;
            for (char ch : word.toCharArray()){
                if (cur.next[ch-'a'] == null)
                    return false;
                cur = cur.next[ch-'a'];
            }
            return word.equals(cur.word);
        }
        public boolean isStartWith(String prefix){
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()){
                if (cur.next[ch-'a'] == null)
                    return false;
            }
            return true;
        }
    }

    private final int[][]direction = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    private int m;
    private int n;
    public List<String>findWords(char[][]board,String[]words){
        Trie trie = new Trie();
        m = board.length;
        n = board[0].length;
        boolean[][]isVisited = new boolean[m][n];
        Set<String>res = new HashSet<>();

        for (String word : words){
            trie.insert(word);
        }
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                backtrack(board,isVisited,i,j,"",trie,res);
            }
        }
        return new ArrayList<>(res);

    }
    private void backtrack(char[][]board,boolean[][]isVisited,int r,  int c,String str,Trie trie,Set<String>res){
        if (r < 0 || r >= m || c < 0 || c >= n || isVisited[r][c])
            return;
        str += board[r][c];
        if (!trie.isStartWith(str))
            return;
        if (trie.search(str)){
            res.add(str);
        }
        isVisited[r][c] = true;
        for (int[]d : direction){
            backtrack(board,isVisited,r+d[0],c+d[1],str,trie,res);
        }
        isVisited[r][c] = false;
    }
}
