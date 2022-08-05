package code.bloomberg;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/company/bloomberg/discuss/406663/Bloomberg-or-Phone-Screen-or-Min-Steps-to-Generate-Number
public class MinimumStepsToGenerateNumber {

    public int minSteps(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int level = 0;

        q.add(1);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n)
                    return level;
                if (visited.contains(curr))
                    continue;
                visited.add(curr);
                q.add(curr * 2);
                q.add(curr / 3);
            }
            level++;
        }

        return -1;
    }
}
