package code.design;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/stream-of-characters/
public class StreamOfCharacters {

    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    Deque<Character> stream;

    public StreamOfCharacters(String[] words) {

        root = new TrieNode();
        stream = new ArrayDeque<>();

        for(String word:words){

            TrieNode temp = root;

            for(int i=word.length()-1;i>=0;i--){

                char c = word.charAt(i);

                if(temp.children[c-'0']==null){
                    temp.children[c-'0'] = new TrieNode();
                }

                temp = root.children[c-'0'];
            }

            temp.isEnd = true;
        }
    }

    public boolean query(char letter) {

        stream.addFirst(letter);

        TrieNode node = root;
        for (char ch : stream) {
            if (node.isEnd) {
                return true;
            }
            if (node.children[ch-'0']==null) {
                return false;
            }
            node = node.children[ch-'0'];
        }
        return node.isEnd;

    }
}
