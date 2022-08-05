package code.march.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://www.youtube.com/watch?v=Jv5_J1fSju0
//https://www.youtube.com/watch?v=KVg4Y0sI4Iw
public class MaximumFrequencyStack {

    int maxFreq;
    Map<Integer, Stack> mapOfStacks;
    Map<Integer,Integer> freqMap;
    public MaximumFrequencyStack() {
        this.maxFreq = 0;
        this.mapOfStacks = new HashMap();
        this.freqMap = new HashMap();
    }

    public static void main(String args[]){

        MaximumFrequencyStack obj = new MaximumFrequencyStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
    public void push(int val) {
        int freq = freqMap.getOrDefault(val,0);
        freq++;
        freqMap.put(val,freq);

        maxFreq = Math.max(maxFreq,freq);

        Stack<Integer> stack = mapOfStacks.getOrDefault(freq,new Stack());
        stack.push(val);
        mapOfStacks.put(freq,stack);
    }

    public int pop() {

        Stack<Integer> stack = mapOfStacks.get(maxFreq);
        int val = stack.pop();
        if(stack.isEmpty()){
            maxFreq--;
        }
        freqMap.put(val,freqMap.get(val)-1);
        return val;
    }

}
