package code.feb.challenge;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
public class EarliestMomentWhenEveryoneBecomeFriends {

    class UnionFind {
        int group[];
        int rank[];

        public UnionFind(int n){
            group = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                group[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x){
            if(group[x]!=x){
                group[x] = find(group[x]);
            }
            return group[x];
        }

        public boolean union(int a,int b){
            int groupA = find(a);
            int groupB = find(b);

            boolean isMerged = false;

            //if both are in same group
            if(groupA==groupB){
                return isMerged;
            }

            isMerged = true;
            if(rank[groupA]<rank[groupB]){
                group[groupA] = groupB;
            }
            else if(rank[groupA]>rank[groupB]){
                group[groupB] = groupA;
            }
            else{
                group[groupA] = groupB;
                rank[groupB]++;
            }

            return isMerged;
        }
    }
    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs,new Comparator<int[]>(){

            public int compare(int log1[],int log2[]){
                Integer t1 = new Integer(log1[0]);
                Integer t2 = new Integer(log2[0]);
                return t1.compareTo(t2);
            }
        });

        int groupCount = n;
        UnionFind uf = new UnionFind(n);

        for(int log[]:logs){
            int timestamp = log[0];
            int friendA = log[1];
            int friendB = log[2];

            if(uf.union(friendA,friendB)){
                groupCount--;
            }

            if(groupCount==1){
                return timestamp;
            }
        }

        return -1;
    }
}
