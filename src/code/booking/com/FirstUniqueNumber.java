package code.booking.com;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/first-unique-number/
public class FirstUniqueNumber {

    public Map<Integer,Boolean> isUnique;
    public Queue<Integer> q;

    public FirstUniqueNumber(int[] nums) {

        this.q = new ArrayDeque();
        this.isUnique = new HashMap();

        for(int num:nums){
            this.add(num);
        }
    }

    public static void main(String args[]){


    }
    public int showFirstUnique() {
        while(!q.isEmpty() && !isUnique.get(q.peek())){
            q.poll();
        }

        if(!q.isEmpty()){
            return q.peek();
        }
        else{
            return -1;
        }
    }

    public void add(int value) {
        if(!isUnique.containsKey(value)){
            isUnique.put(value,true);
            q.add(value);
        }
        else{
            isUnique.put(value,false);
        }
    }
}
