package code.graph;

import java.util.*;

//https://leetcode.com/problems/word-ladder/submissions/
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.equals(endWord)){
            return 0;
        }

        Set<String> set = new HashSet<>();

        for(String str:wordList){
            set.add(str);
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int turns = 1;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                String str = q.remove();

                if(endWord.equals(str)){
                    return turns;
                }

                for(int j=0;j<str.length();j++){

                    char carray[] = str.toCharArray();

                    for(char k='a';k<='z';k++){

                        char oldChar = str.charAt(j);
                        carray[j] = k;

                        String newStr = new String(carray);

                        if(!visited.contains(newStr) && set.contains(newStr)){
                            q.add(newStr);
                            visited.add(newStr);
                        }

                        carray[j] = oldChar;
                    }
                }
            }

            turns++;
        }

        return 0;
    }
}
