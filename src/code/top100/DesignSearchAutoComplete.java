package code.top100;

import java.util.Map;

public class DesignSearchAutoComplete {

    class TrieNode{
        char c;
        Map<TrieNode,TrieNode> children;
        Map<String,Integer> counts;
        public TrieNode(){

        }
    }
}
