package code.booking.com;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://stackoverflow.com/questions/59520626/how-to-minimize-the-sum-of-the-elements-in-the-final-array-after-performing-k-nu
public class MinimizeSumOfElementsAfterPerformingKOperations {

    long sum(List<Integer> data, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        pQueue.addAll(data);
        while (k-- > 0) {
            pQueue.add((int) Math.ceil(pQueue.poll() / 2d));
        }
        return pQueue.stream().mapToInt(a -> a).sum();
    }
}
