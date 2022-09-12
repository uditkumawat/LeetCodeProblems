package code.amazon;

import java.util.Arrays;

//https://leetcode.com/problems/connecting-cities-with-minimum-cost/

/**
 * There are n cities labeled from 1 to n. You are given the integer n and an array connections where connections[i] = [xi, yi, costi] indicates that the cost of connecting city xi and city yi (bidirectional connection) is costi.
 *
 * Return the minimum cost to connect all the n cities such that there is at least one path between each pair of cities. If it is impossible to connect all the n cities, return -1,
 *
 * The cost is the sum of the connections' costs used.
 */
public class ConnectingCitiesWithMinimumCost {

    int parent[];
    int n;
    public int minimumCost(int n, int[][] connections) {
        this.parent = new int[n+1];
        this.n = n+1;

        for(int i=0;i<=n;i++){
            this.parent[i] = i;
        }
        Arrays.sort(connections,(int a[], int b[])->{
            return a[2]-b[2];
        });
        int res = 0;

        for(int connection[]:connections){

            int x = connection[0];
            int y = connection[1];

            if(find(x)!=find(y)){
                res+=connection[2];
                union(x,y);
            }
        }

        return res;
    }

    public int find(int x){
        if(parent[x]==x){
            return parent[x];
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x,int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX!=parentY){
            parent[parentX] = parentY;
        }
    }
}
