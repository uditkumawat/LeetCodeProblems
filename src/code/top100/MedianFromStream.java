package code.top100;

import java.util.PriorityQueue;

public class MedianFromStream {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double getMedian(){
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())*1.0/2.0;
        }
        else{
            return maxHeap.peek();
        }
    }

    public void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
}
