package code.november2022.challenge;

import java.util.*;

//https://leetcode.com/problems/minimum-genetic-mutation/description/
//BFS approach
public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        Set<String> set = new HashSet();
        for(String str:bank){
            set.add(str);
        }

        if(!set.contains(end)){
            return -1;
        }

        Queue<String> q = new LinkedList();
        q.add(start);
        Set<String> visited = new HashSet();
        visited.add(start);

        int steps = 0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-->0){
                String s = q.remove();

                if(end.equals(s)){
                    return steps;
                }

                for(String str:getAllNextMutation(s)){
                    if(!visited.contains(str) && set.contains(str)){
                        q.add(str);
                        visited.add(str);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private List<String> getAllNextMutation(String str){

        List<String> res = new ArrayList();

        char c[] = str.toCharArray();

        char chars[] = {'A','C','G','T'};

        for(int i=0;i<c.length;i++){
            for(int j=0;j<chars.length;j++){
                char temp = c[i];
                c[i] = chars[j];
                res.add(new String(c));
                c[i] = temp;
            }
        }

        System.out.println(res);
        return res;
    }
}
