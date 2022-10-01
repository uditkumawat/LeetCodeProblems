package code.leetcodeTopInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-skyline-problem/discussion/
//https://www.youtube.com/watch?v=POUMNJou4vc
public class TheSkylineProblem {

    class Pair implements Comparable<Pair>{
        int x;
        int ht;
        Pair(int x,int ht){
            this.x = x;
            this.ht = ht;
        }

        public int compareTo(Pair obj){
            if(this.x==obj.x){
                return this.ht-obj.ht;
            }
            else{
                return this.x-obj.x;
            }
        }

    }
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> res = new ArrayList();
        List<Pair> list = new ArrayList();

        if(buildings==null || buildings.length==0){
            return res;
        }

        for(int i=0;i<buildings.length;i++){
            int sp = buildings[i][0];
            int ep = buildings[i][1];
            int ht = buildings[i][2];

            list.add(new Pair(sp,-ht));
            list.add(new Pair(ep,ht));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1, i2)->{
            return i2-i1;
        });

        int cht = 0;
        pq.add(0);

        for(int i=0;i<list.size();i++){
            int x = list.get(i).x;
            int ht = list.get(i).ht;

            if(ht<0){
                pq.add(-ht);
            }
            else{
                pq.remove(ht);
            }

            if(cht!=pq.peek()){
                List<Integer> temp = new ArrayList();
                temp.add(x);
                temp.add(pq.peek());

                res.add(temp);
                cht = pq.peek();
            }
        }
        return res;
    }
}
