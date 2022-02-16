package code.design;

import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=_T2JmeMncW0
//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFromDataStream {

    PriorityQueue<Integer> maxHeap = null;
    PriorityQueue<Integer> minHeap = null;

    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>((a,b)->(b-a));
        minHeap = new PriorityQueue<Integer>((a,b)->(a-b));
    }

    public static void main(String args[]){
        MedianFromDataStream obj = new MedianFromDataStream();

        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
    public void addNum(int num) {

        if(maxHeap.isEmpty() || maxHeap.peek()>=num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        //balancing both heaps
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
        else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else{
            return minHeap.peek();
        }
    }
}
