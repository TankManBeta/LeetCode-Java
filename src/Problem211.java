/*
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
实现词典类 WordDictionary ：
    WordDictionary() 初始化词典对象
    void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
    bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。
    word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。

输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // 返回 False
wordDictionary.search("bad"); // 返回 True
wordDictionary.search(".ad"); // 返回 True
wordDictionary.search("b.."); // 返回 True
 */
/*
思路：和208一样的思路，用字典树，对于'.'的情况要遍历所有孩子节点
 */

class TrieNode{
    private TrieNode[] children;
    private boolean isEnd;

    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }

    public void insert(String word){
        TrieNode node = this;
        for (int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isEnd(){
        return isEnd;
    }
}

public class Problem211 {
    private TrieNode root;

    public Problem211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode node){
        if (index == word.length()){
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            TrieNode child = node.getChildren()[childIndex];
            return child != null && dfs(word, index + 1, child);
        }else{
            for (int i=0; i<26; i++){
                TrieNode child = node.getChildren()[i];
                if (child!=null && dfs(word, index + 1, child)){
                    return true;
                }
            }
        }
        return false;
    }
}

