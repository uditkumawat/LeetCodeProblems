package code.top100;

//TC - Insert - O(M) - where M is number of characters in word
//SC - O(M)
public class Trie {

    public static void main(String args[]){
        TrieClass obj  = new TrieClass();
        obj.insert("udit");
        obj.insert("kuamwat");
        System.out.println(obj.search("uk"));
        System.out.println(obj.search("udit"));
        System.out.println(obj.startsWith("u"));
        System.out.println(obj.startsWith("k"));
        System.out.println(obj.startsWith("s"));
    }

    static class TrieClass {
        class TrieNode {
            public char c;
            public boolean isWord;
            public TrieNode children[];

            TrieNode(char c) {
                this.c = c;
                this.isWord = false;
                this.children = new TrieNode[26];
            }
        }

        /**
         * Initialize your data structure here.
         */
        private TrieNode root;

        public TrieClass() {
            root = new TrieNode('\0');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode(c);
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = getNode(word);
            return node != null && node.isWord == true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = getNode(prefix);
            return node != null;
        }

        public TrieNode getNode(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    return null;
                }
                curr = curr.children[c - 'a'];
            }
            return curr;
        }
    }
}
