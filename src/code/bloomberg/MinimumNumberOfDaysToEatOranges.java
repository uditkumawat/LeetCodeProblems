package code.bloomberg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumNumberOfDaysToEatOranges {

    public int minDays(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int res = 0;
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == 0) {
                    return res - 1;
                }
                if (set.contains(cur)) {
                    continue;
                } else {
                    set.add(cur);
                }
                if (cur % 3 == 0) {
                    q.offer(cur / 3);
                }
                if (cur % 2 == 0) {
                    q.offer(cur / 2);
                }
                q.offer(cur - 1);
            }
        }

        return res;

    }
}
