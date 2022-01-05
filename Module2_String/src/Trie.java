/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 *          a b c d e ..... z
 *          |               |
 *    a b c d e ..... z    a b c d e ..... z
 *    在前缀树中用 flag表示这里截至是否是一个单词，
 *    insert就是不断填充一层一层的数组，最后置true
 *    查找 search和startwith很像，可以复用，查找最后一位字母的trie，然后看是否为null 以及flag
 *
 *    word 和 prefix 仅由小写英文字母组成
 */

public class Trie {

        private Trie[] children; //下一层
        private boolean isWordEnd; //true则表示此时存在单词在此结束
        public Trie() {
            this.children = new Trie[26];
            this.isWordEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for(int i = 0;i<word.length();i++){
                Trie [] child = node.children;
                int index = word.charAt(i)-'a';
                if(child[index]==null){ //如果字母不存在就写上去
                    child[index] = new Trie();
                }
                node = child[index];
                if(i==word.length()-1){ //最后一个字母 记为true;
                    node.isWordEnd=true;
                }
            }

        }

        public boolean search(String word) {
            Trie lastOne = searchLastOne(word);
            if(lastOne==null|| !lastOne.isWordEnd){ //找不到最后一个字母的节点或者不是单词的结束
                return false;
            }else {
                return true;
            }
        }

        public boolean startsWith(String prefix) {
            Trie lastOne = searchLastOne(prefix);
            return lastOne!=null;
        }

    private Trie searchLastOne(String prefix) { //查找最后一个字母的Trie
            Trie node = this;
            for(int i=0;i<prefix.length();i++){
                Trie[] child = node.children;
                int index = prefix.charAt(i)-'a';
                if(child[index]==null){ //找不到就是null
                    return null;
                }else { //找不到则下一步
                    node = child[index];
                }
            }
            return node;
    }
}
