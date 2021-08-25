package code.leetcode.doordash;

import java.util.PriorityQueue;

/**
 * Time:
 * Constructor: O(1)
 * addNum: O(logN)
 * findMedian: O(1)
 * Space: O(N)
 */
public class MedianFromStream {

        public static void main(String args[]){
            MedianFinder mf = new MedianFinder();
            mf.init();
            mf.addNum(1);
            mf.addNum(2);
            mf.addNum(3);
            mf.addNum(4);
            mf.addNum(5);
            System.out.println(mf.findMedian());
            mf.addNum(6);
            System.out.println(mf.findMedian());
        }

        static class MedianFinder {

            private PriorityQueue<Integer> maxHeap;
            private PriorityQueue<Integer> minHeap;

            public void init() {
                maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
                minHeap = new PriorityQueue<Integer>();
            }

            public void addNum(int num) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
                if (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }

            public double findMedian() {
                if (maxHeap.size() == minHeap.size()) {
                    return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
                } else {
                    return maxHeap.peek();
                }
            }
        }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
