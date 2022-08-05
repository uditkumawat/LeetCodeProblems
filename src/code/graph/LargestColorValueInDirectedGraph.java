package code.graph;

import java.util.*;

//https://leetcode.com/problems/largest-color-value-in-a-directed-graph/discuss/1539293/Java-or-Topological-Order-or-O(M%2BN)
//https://leetcode.com/problems/largest-color-value-in-a-directed-graph/discuss/1220930/C%2B%2B%3A-DP-%2B-Topological-Sort-(Kahn's-Algorithm)-solution
//https://leetcode.com/problems/largest-color-value-in-a-directed-graph/discuss/1923519/Java-Solution-using-Topo-sort-%2B-DP
public class LargestColorValueInDirectedGraph {

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length(), visited = 0, res = 0;
        Map<Integer, Set<Integer>> dep = new HashMap();
        int[] inDegree = new int[n];
        int[][] max = new int[n][26];
        for(int[]e : edges) {
            int u = e[0], v = e[1];
            dep.computeIfAbsent(u, x -> new HashSet()).add(v);
            inDegree[v]++;
        }
        Deque<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            visited += size;
            while(size-- > 0) {
                int cur = q.poll(), color = colors.charAt(cur) -'a';
                max[cur][color]++;
                res = Math.max(res, max[cur][color]); // update the result of the current color, since only the number of current color increased
                for(int nei : dep.getOrDefault(cur, new HashSet<>())) {
                    for(int i = 0; i < 26; i++) {
                        max[nei][i] = Math.max(max[cur][i], max[nei][i]); // maximum number of nodes for each color to reach ith node
                    }
                    inDegree[nei]--;
                    if(inDegree[nei] == 0) q.offer(nei);
                }
            }

        }
        return visited == n ? res : -1;
    }
}
