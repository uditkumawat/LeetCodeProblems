package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/all-paths-from-source-to-target/

/**
 * As a result, for a graph with NN nodes, at maximum, there could be \sum_{i=0}^{N-2}{2^i} = 2^{N-1} - 1∑
 * i=0
 * N−2
 * ​
 *  2
 * i
 *  =2
 * N−1
 *  −1 number of paths between the starting and the ending nodes.
 *
 * Time Complexity: \mathcal{O}(2^N \cdot N)O(2
 * N
 *  ⋅N)
 *
 * As we calculate shortly before, there could be at most 2^{N-1} - 12
 * N−1
 *  −1 possible paths in the graph.
 *
 * For each path, there could be at most N-2N−2 intermediate nodes, i.e. it takes \mathcal{O}(N)O(N) time to build a path.
 *
 * To sum up, a loose upper-bound on the time complexity of the algorithm would be (2^{N-1} - 1) \cdot \mathcal{O}(N) = \mathcal{O}(2^N \cdot N)(2
 * N−1
 *  −1)⋅O(N)=O(2
 * N
 *  ⋅N), where we consider it takes \mathcal{O}(N)O(N) efforts to build each path.
 *
 * It is a loose uppper bound, since we could have overlapping among the paths, therefore the efforts to build certain paths could benefit others.
 *
 * Space Complexity: \mathcal{O}(2^N \cdot N)O(2
 * N
 *  ⋅N)
 *
 * Similarly, since at most we could have 2^{N-1}-12
 * N−1
 *  −1 paths as the results and each path can contain up to NN nodes, the space we need to store the results would be \mathcal{O}(2^N \cdot N)O(2
 * N
 *  ⋅N).
 *
 * Since we also applied recursion in the algorithm, the recursion could incur additional memory consumption in the function call stack. The stack can grow up to NN consecutive calls. Meanwhile, along with the recursive call, we also keep the state of the current path, which could take another \mathcal{O}(N)O(N) space. Therefore, in total, the recursion would require additional \mathcal{O}(N)O(N) space.
 *
 * To sum up, the space complexity of the algorithm is \mathcal{O}(2^N \cdot N) + \mathcal{O}(N) = \mathcal{O}(2^N \cdot N)O(2
 * N
 *  ⋅N)+O(N)=O(2
 * N
 *  ⋅N).
 */
public class AllPAthsFromSourceToTarget {

        private int targetNode;
        private int[][] graph;
        private List<List<Integer>> results;

        public void backtrack(int currentNode,LinkedList<Integer> path){
            if(currentNode == this.targetNode){
                this.results.add(new ArrayList<Integer>(path));
                return;
            }

            for(int neighbourNode : this.graph[currentNode]){
                path.add(neighbourNode);
                this.backtrack(neighbourNode,path);
                path.removeLast();
            }
        }

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.targetNode = graph.length-1;
            this.graph = graph;
            this.results = new ArrayList<List<Integer>>();

            LinkedList<Integer> path = new LinkedList<Integer>();
            path.addLast(0);

            this.backtrack(0,path);

            return this.results;
        }
}
