package trie;

/**
 * @author kanglo
 * @create 2022-07-2022/7/9 19:58
 */
public class MagicDictionary {
    class Node {
        boolean end;
        Node[]children = new Node[26];
    }
    Node root;
    public MagicDictionary(){
        root = new Node();
    }
    public void buildDict(String[]dictionary){

        for (String word : dictionary){
            Node cur = root;
            for (int i = 0; i < word.length();i++){
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null)
                    cur.children[index] = new Node();
                cur = cur.children[index];
            }
            cur.end = true;
        }
    }
    public boolean search(String searchWord){

        return dfs(root,searchWord,0,false);
    }
    private boolean dfs(Node cur,String searchWord,int idx,boolean modified){
        if (idx == searchWord.length()){
            return modified && cur.end;
        }
        int index = searchWord.charAt(idx) - 'a';
        if (cur.children[index] != null){
            if (dfs(cur.children[index],searchWord,idx+1,modified ))
                return true;
        }
        if (!modified){
            for (int i = 0; i < 26;i++){
                if (i != index && cur.children[i] != null){
                    if (dfs(cur.children[i],searchWord,idx+1,true ))
                        return true;
                }
            }
        }
        return false;
    }


}
