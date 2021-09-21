package tree.trie;

/**
 * @author kanglo
 * @create 2021-09-2021/9/20 15:28
 */
public class MagicDictionary {
    class TrieNode{
        TrieNode[]next = new TrieNode[26];
        boolean isEnd = false;
        public TrieNode(){

        }
        public void insert(String word){
            TrieNode cur = this;
            for (char ch : word.toCharArray()){
                if (cur.next[ch-'a'] == null)
                    cur.next[ch-'a'] = new TrieNode();
                cur = cur.next[ch-'a'];
            }
            cur.isEnd = true;
        }
        public boolean search(TrieNode cur,String word,int count,int index){
            if (count > 1)
                return false;
            if (index == word.length()){
                return count == 1 && cur.isEnd;
            }
            char ch = 'a';
            for (TrieNode next : cur.next){
                if (next != null){
                    if (search(next,word,ch == word.charAt(index) ? count : count+1,index+1))
                        return true;
                }
                ch++;
            }
            return false;

        }

    }
    TrieNode trieNode;
    public MagicDictionary(){
        trieNode = new TrieNode();
    }
    public void buildDict(String[]dictionary){
        for (String word : dictionary){
            trieNode.insert(word);
        }
    }
    public boolean search(String searchWord){
        return trieNode.search(trieNode,searchWord,0,0);
    }
}
