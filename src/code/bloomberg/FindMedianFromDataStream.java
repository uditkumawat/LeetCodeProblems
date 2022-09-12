package code.bloomberg;

import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/solution/
public class FindMedianFromDataStream {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<Integer>((a,b)->{
            return a-b;
        });
        maxHeap = new PriorityQueue<Integer>((a,b)->{
            return b-a;
        });
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek()>=num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
        balanceHeaps();
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else if(minHeap.size()>maxHeap.size()){
            return minHeap.peek();
        }
        else{
            return (maxHeap.peek()+minHeap.peek())*1.0/2;
        }
    }

    public void balanceHeaps(){
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.poll());
        }
    }
}
