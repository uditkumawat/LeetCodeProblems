package code.google;

import java.util.HashMap;
import java.util.Map;

public class AddSearchWordDataStructure {

    class TrieNode
    {
        Map<Character,TrieNode> children;
        boolean isEndOfWord;
        TrieNode(){
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    TrieNode root;

    public AddSearchWordDataStructure() {
        root = new TrieNode();
    }

    //TC - O(M) - Length of word, atleast we traverse the whole string
    //SC - O(M) - If it is totally new word and it adds new nodes to Trie
    public void addWord(String word) {

        TrieNode temp = root;
        for(char c:word.toCharArray()){
            if(!temp.children.containsKey(c)){
                temp.children.put(c,new TrieNode());
            }
            temp = temp.children.get(c);
        }
        temp.isEndOfWord = true;
    }

    public boolean searchInNode(String word,TrieNode root) {
        TrieNode temp = root;

        for(int i=0;i<word.length();i++){

            char c = word.charAt(i);

            if(!temp.children.containsKey(c)){

                if(c=='.'){

                    for(char x:temp.children.keySet()){

                        TrieNode child = temp.children.get(x);

                        if(searchInNode(word.substring(i+1),child)){
                            return true;
                        }
                    }
                }
                return false;
            }
            else{
                temp = temp.children.get(c);
            }
        }
        return temp!=null && temp.isEndOfWord;
    }

    public boolean search(String word){
        return searchInNode(word,root);
    }

    public static void main(String args[]){

        AddSearchWordDataStructure obj = new AddSearchWordDataStructure();

        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));

    }
}
