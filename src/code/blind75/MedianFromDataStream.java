package code.blind75;

import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/submissions/
//TC - O(logn)
//Sc - O(N)
public class MedianFromDataStream {

    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;

    public MedianFromDataStream() {
        maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
        minHeap = new PriorityQueue<Integer>((a,b)->a-b);
    }

    public void addNum(int num) {
        if(maxHeap.size()==0 || maxHeap.peek()>=num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        balance();
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else if(maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }
        else{
            return (maxHeap.peek()+minHeap.peek())*1.0/2;
        }
    }

    public void balance(){
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.poll());
        }
    }
}
