package code.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectionCitiesWithMinimumCost {

    class DisjointSet{
        private int weights[];
        private int parents[];

        public void union(int a,int b){
            int rootA = find(a);
            int rootB = find(b);
            // If both a and b have same root, i.e. they both belong to the same set, hence we don't need to take union
            if (rootA == rootB) return;

            // Weighted union
            if (this.weights[rootA] > this.weights[rootB]) {
                // In case rootA is having more weight
                // 1. Make rootA as the parent of rootB
                // 2. Increment the weight of rootA by rootB's weight
                this.parents[rootB] = rootA;
                this.weights[rootA] += this.weights[rootB];
            } else {
                // Otherwise
                // 1. Make rootB as the parent of rootA
                // 2. Increment the weight of rootB by rootA's weight
                this.parents[rootA] = rootB;
                this.weights[rootB] += this.weights[rootA];
            }
        }

        public int find(int a){
            while(a!=this.parents[a]){
                // Path compression
                // a's grandparent is now a's parent
                this.parents[a] = this.parents[this.parents[a]];
                a = this.parents[a];
            }
            return a;
        }

        public boolean isInSameGroup(int a,int b){
            return find(a)==find(b);
        }

        public DisjointSet(int n){
            this.parents = new int[n+1];
            this.weights = new int[n+1];
            for(int i=1;i<=n;i++){
                this.parents[i] = i;
                this.weights[i] = 1;
            }
        }

    }
    class Solution {

        public int minimumCost(int n, int[][] connections) {

            DisjointSet disjointSet = new DisjointSet(n);

            Arrays.sort(connections,(a, b)->a[2]-b[2]);

            int total = 0;

            int cost = 0;

            for(int i=0;i<connections.length;i++){

                int a = connections[i][0];
                int b = connections[i][1];

                // Do not add the edge from a to b if it is already connected
                if(disjointSet.isInSameGroup(a,b)){
                    continue;
                }

                disjointSet.union(a,b);

                cost = cost + connections[i][2];

                total++;
            }

            //total edges will be equal to n-1 i.e number of nodes -1
            //// If all N nodes are connected, the MST will have a total of N - 1 edges
            if(total==n-1){
                return cost;
            }else{
                return -1;
            }

        }
    }

    class SolutionBasedOnDijkastra{

        public int minimumCost(int n,int connections[][]){

            if(n==1){
                return 0;
            }

            List<List<int[]>> graph = new ArrayList();
            for(int i=0;i<=n;i++){
                graph.add(new ArrayList());
            }

            for(int connection[]:connections){
                int source = connection[0];
                int destination = connection[1];
                int cost = connection[2];
                graph.get(source).add(new int[]{destination,cost});
                graph.get(destination).add(new int[]{source,cost});
            }

            boolean visited[] = new boolean[n+1];

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.offer(new int[]{1,0});

            int cost = 0;
            int cities = 0;

            while(!pq.isEmpty()){
                int node[] = pq.poll();
                if(!visited[node[0]]){
                    continue;
                }

                visited[node[0]] = true;
                cost+=node[1];
                cities++;

                for(int v[]:graph.get(node[0])){
                    if(!visited[v[0]]){
                        pq.offer(new int[]{v[0],v[1]});
                    }
                }
            }

            return cities==n ? cost:-1;
        }
    }
}
